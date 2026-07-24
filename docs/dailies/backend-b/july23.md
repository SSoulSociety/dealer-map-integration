# Gün 13 - Spring Cloud Gateway ve CORS taşıma

## Bugün ne yaptım
api-gateway modülünü Spring Boot 3.3.1 + Spring Cloud Gateway (2023.0.3) ile kurdum; port 8085. Route'lar: /api/pasaj/** → stock-service (StripPrefix=2), /api/stores/** → store-service (StripPrefix=1), /api/comtr/** → capability-service (StripPrefix=2). CORS'u gateway'de CorsWebFilter ile merkezileştirdim (GET/PUT/OPTIONS, 5173 ve 3000). Backend B tarafında store-service ve capability-service'teki CorsConfig sınıflarını ve app.cors yaml'ını kaldırdım — stock-service CORS temizliğini Backend A'ya bıraktım. Servisler arası RestClient çağrıları doğrudan store-service'e gitmeye devam ediyor.

## Ne anladım
Gateway bir cross-cutting concern noktasıdır: routing ve CORS gibi her serviste tekrarlanan işler tek yerde toplanır. StripPrefix route prefix tasarımına göre değişir (/api/stores/1 → /stores/1 için 1; /api/pasaj/products → /products için 2). Frontend tek base URL (:8085) kullanınca CORS ve ortam config'i sadeleşir; microservice'lerin kendi portlarına tarayıcıdan gitmesi gerekmez.

## Ne anlamadım / kafama takılanlar
- stock-service hâlâ kendi CorsConfig'ini tutuyorsa gateway + servis çift CORS header'ı sorun çıkarır mı?
- Gateway'e request logging ve rate limiting (Gün 14) eklerken Redis RateLimiter filtre mi, custom GlobalFilter mi tercih edilmeli?

## Yarın standup'ta sormak istediğim
Frontend .env base URL'ini gateway'e (http://localhost:8085) çevirirken path prefix'lerini (/api/pasaj, /api/stores, /api/comtr) kim güncelleyecek; Postman collection'larını da gateway URL'ine mi taşıyacağız?
