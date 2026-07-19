# capability-service

turkcell.com.tr **"Yakınımda İşlem"** modülünün backend servisi (Backend B).

## Amaç

"Bu işlemi hangi bayi yapabiliyor?" sorusunu cevaplar. Bayi detayını **kopyalamaz** — `store_id` tutar, detay için `store-service`'e RestClient ile gider.

## Port

`8082`

## Endpoint'ler (API Contract 3.6–3.7 + Gün 7 filtre)

| Method | Path | Açıklama |
|--------|------|----------|
| GET | `/capabilities/types` | İşlem tipi dropdown |
| GET | `/capabilities/{type}/stores?lat=&lng=&radius=` | Yakın yetkin bayiler |
| GET | `/capabilities/{type}/stores?...&workingHours=weekend&status=ACTIVE` | Parametreli filtre (Gün 7) |

## Çalıştırma

Önkoşul: Oracle ayakta + **store-service (8081)** ayakta.

```bash
# proje kökünden
docker compose up -d oracle

# store-service
cd store-service && mvnw.cmd spring-boot:run

# capability-service (ayrı terminal)
cd capability-service && mvnw.cmd spring-boot:run
```

Swagger: http://localhost:8082/swagger-ui.html

## Örnek istek

```http
GET http://localhost:8082/capabilities/DEVICE_REPAIR/stores?lat=41.02&lng=29.01&radius=10&status=ACTIVE&workingHours=weekend
```
