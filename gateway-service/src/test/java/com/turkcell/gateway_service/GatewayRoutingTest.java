package com.turkcell.gateway_service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GatewayRoutingTest {

    private static final HttpServer stockService = startStockService();

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    @AfterAll
    static void stopStockService() {
        stockService.stop(0);
    }

    @DynamicPropertySource
    static void gatewayProperties(DynamicPropertyRegistry registry) {
        registry.add(
                "STOCK_SERVICE_BASE_URL",
                () -> "http://localhost:" + stockService.getAddress().getPort());
    }

    @Test
    void routesPasajRequestsToStockServiceAndStripsGatewayPrefix() {
        webTestClient.get()
                .uri("/api/pasaj/products?category=phone")
                .header("X-Correlation-Id", "test-correlation-id")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("X-Correlation-Id", "test-correlation-id")
                .expectBody(String.class)
                .value(body -> assertThat(body).isEqualTo("/products?category=phone"));
    }

    @Test
    void handlesCorsPreflightAtGateway() {
        webTestClient.method(HttpMethod.OPTIONS)
                .uri("/api/pasaj/products")
                .header(HttpHeaders.ORIGIN, "http://localhost:5173")
                .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals(
                        HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
                        "http://localhost:5173")
                .expectHeader().valueEquals(
                        HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                        "GET,PUT,OPTIONS");
    }

    @Test
    void createsCorrelationIdWhenClientDoesNotSendOne() {
        webTestClient.get()
                .uri("/api/pasaj/products")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().exists("X-Correlation-Id");
    }

    @Test
    void appliesRedisRateLimiterOnlyToStockWriteRoute() {
        var routes = routeDefinitionLocator.getRouteDefinitions().collectList().block();

        assertThat(routes).isNotNull();
        var writeRoute = routes.stream()
                .filter(route -> route.getId().equals("stock-service-write"))
                .findFirst()
                .orElseThrow();

        assertThat(writeRoute.getFilters())
                .extracting(filter -> filter.getName())
                .containsExactly("StripPrefix", "RequestRateLimiter");
    }

    private static void respondWithRequestPath(HttpExchange exchange) throws IOException {
        String response = exchange.getRequestURI().toString();
        byte[] body = response.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, body.length);
        exchange.getResponseBody().write(body);
        exchange.close();
    }

    private static HttpServer startStockService() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
            server.createContext("/products", GatewayRoutingTest::respondWithRequestPath);
            server.setExecutor(Executors.newSingleThreadExecutor());
            server.start();
            return server;
        } catch (IOException exception) {
            throw new IllegalStateException("Could not start test stock service", exception);
        }
    }
}
