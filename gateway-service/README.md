# Gateway Service

`gateway-service` is the single HTTP entry point for the dealer map
microservices. It runs on port `8083`; the existing service ports stay
unchanged.

The service uses Spring Boot `4.1.0`, Spring Cloud `2025.1.2`, and Spring Cloud
Gateway Server WebFlux `5.0.2`. Java 17 or newer is required.

## Day 13 scope

- Routes `/api/pasaj/**` requests to `stock-service` on port `8080`
- Removes the `/api/pasaj` prefix before forwarding
- Handles frontend CORS at the gateway
- Propagates an existing `X-Correlation-Id` or creates a new one
- Logs method, path, response status, correlation ID, and request duration
- Rate limits stock update requests by client IP using Redis
- Applies connection and response timeouts
- Exposes only Actuator health and info endpoints

## Port map

| Application | Port |
|---|---:|
| Stock Service | 8080 |
| Store Service | 8081 |
| Capability Service | 8082 |
| API Gateway | 8083 |

## Routes

| Public Gateway URL | Internal Stock Service URL |
|---|---|
| `GET /api/pasaj/products` | `GET /products` |
| `GET /api/pasaj/products/{id}/stores` | `GET /products/{id}/stores` |
| `PUT /api/pasaj/products/{productId}/stores/{storeId}/stock` | `PUT /products/{productId}/stores/{storeId}/stock` |

Query parameters and request bodies are forwarded without modification.

## Configuration

| Variable | Default |
|---|---|
| `SERVER_PORT` | `8083` |
| `STOCK_SERVICE_BASE_URL` | `http://localhost:8080` |
| `FRONTEND_ALLOWED_ORIGIN` | `http://localhost:5173` |
| `GATEWAY_CONNECT_TIMEOUT_MS` | `2000` |
| `GATEWAY_RESPONSE_TIMEOUT` | `5s` |
| `REDIS_HOST` | `localhost` |
| `REDIS_PORT` | `6379` |
| `STOCK_WRITE_RATE_PER_SECOND` | `5` |
| `STOCK_WRITE_BURST_CAPACITY` | `10` |

The rate limiter applies only to
`PUT /api/pasaj/products/{productId}/stores/{storeId}/stock`. Start the shared
Redis container before exercising that route through the Gateway:

```powershell
docker compose up -d redis
```

## Run and test

```powershell
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

Health check:

```text
http://localhost:8083/actuator/health
```

Public Stock Service checks:

```text
GET http://localhost:8083/api/pasaj/products
GET http://localhost:8083/api/pasaj/products/1/stores?lat=41.02&lng=29.01&radius=10
PUT http://localhost:8083/api/pasaj/products/1/stores/1/stock
```

The repeatable Day 13 Postman scenario is located at
`../stock-service/postman/stock-service-day13-gateway.postman_collection.json`.
