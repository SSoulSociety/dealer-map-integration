# API Gateway (Day 13)

Spring Cloud Gateway — frontend için tek giriş noktası.

## Port

`8085`

## Route'lar

| Frontend path | Downstream | Örnek |
|---------------|------------|--------|
| `/api/pasaj/**` | stock-service `:8080` (StripPrefix=2) | `GET /api/pasaj/products` → `/products` |
| `/api/stores/**` | store-service `:8081` (StripPrefix=1) | `GET /api/stores/1` → `/stores/1` |
| `/api/comtr/**` | capability-service `:8082` (StripPrefix=2) | `GET /api/comtr/capabilities/types` → `/capabilities/types` |

## CORS

CORS yalnızca gateway'de tanımlıdır (`app.cors.allowed-origins`).  
Backend B servislerinden (store / capability) servis seviyesi CORS kaldırıldı.  
`stock-service` CORS temizliği Backend A tarafında yapılır.

## Çalıştırma

Önkoşul: `stock-service` (8080), `store-service` (8081), `capability-service` (8082) ayakta.

```bash
cd api-gateway
mvnw.cmd spring-boot:run
```

Health: http://localhost:8085/actuator/health

## Örnek istekler

```http
GET http://localhost:8085/api/stores/1
GET http://localhost:8085/api/comtr/capabilities/DEVICE_REPAIR/stores?lat=41.02&lng=29.01&radius=10
GET http://localhost:8085/api/pasaj/products
```

Servisler arası çağrılar (capability → store) doğrudan `localhost:8081` üzerinden devam eder; gateway'e zorunlu değildir.
