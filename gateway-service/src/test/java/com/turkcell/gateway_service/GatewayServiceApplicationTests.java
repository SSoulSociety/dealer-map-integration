package com.turkcell.gateway_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "STOCK_SERVICE_BASE_URL=http://localhost:65535")
class GatewayServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}
