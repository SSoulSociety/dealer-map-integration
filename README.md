# Bayi Harita Entegrasyonu

## Proje Özeti

İki ayrı ürün, tek ortak altyapı mantığı:

- **Pasaj - "Yakınımda Stokta":** Kullanıcı bir ürünün hangi bayide stokta olduğunu harita üzerinde görür. (Backend Stajyer A)
- **turkcell.com.tr - "Yakınımda İşlem":** Kullanıcı yapmak istediği işlemi (yeni hat, cihaz teslim, numara taşıma vb.) seçer, o işlemi yapabilen en yakın bayiyi haritada görür. (Backend Stajyer B)
- **Frontend:** Her iki modülü de içeren tek bir React uygulaması. (Frontend Stajyer)
--- 
## Project Structure

```txt
dealer-map-integration
├── docker-compose.yml   (Oracle Free)
├── gateway-service      (port 8083 — API Gateway)
├── stock-service        (port 8080 — Pasaj / Backend A)
├── store-service        (port 8081 — Bayi master data / Backend B)
├── capability-service   (port 8082 — İşlem yetkinliği / Backend B)
├── frontend
└── docs
```

## Local Oracle

```bash
docker compose up -d oracle
```

- Port: `1521` / Service: `FREEPDB1`
- App user: `store_app` / `StoreApp123`
- SQL: `store-service/sql/`
- API contract: [`docs/api-contract.md`](docs/api-contract.md)

## Backend B (store + capability)

```bash
# Terminal 1
cd store-service && mvnw.cmd spring-boot:run

# Terminal 2 (store-service ayaktayken)
cd capability-service && mvnw.cmd spring-boot:run
```

- Store Swagger: http://localhost:8081/swagger-ui.html
- Capability Swagger: http://localhost:8082/swagger-ui.html
