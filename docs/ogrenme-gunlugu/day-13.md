# Gün 13 — Spring Cloud Gateway Entegrasyonu, Base URL ve Ortam Değişkenleri (.env)

## Bugün ne yaptım
Bugün frontend uygulamasındaki tüm doğrudan mikroservis API çağrılarını tek bir noktada toplayarak, Day 13 kapsamında kurulan Spring Cloud Gateway (`:8085`) adresi üzerine yönlendirdim. Bu entegrasyonu dinamik kılmak amacıyla `frontend/.env` dosyasını oluşturup `VITE_API_GATEWAY_URL` çevre değişkenini tanımlayarak `client.ts` dosyasına bağladım.

## Ne anladım
- **API Gateway Kolaylığı:** Frontend tarafında her mikroservisin portunu (`8080`, `8081`, `8082`) ayrı ayrı bilip yönetmek yerine, tek bir giriş kapısı (Single Entry Point - `:8085`) üzerinden `/api/pasaj` ve `/api/comtr` şeklinde yönlendirmeler yapmanın mimariyi ne kadar sadeleştirdiğini gördüm.
- **Vite Ortam Değişkenleri:** Vite projesinde çevre değişkenlerinin `VITE_` ön ekiyle başlaması gerektiğini ve bunlara `import.meta.env.VITE_...` söz dizimi ile güvenle ulaşıldığını öğrendim.

## Ne anlamadım / kafama takılanlar
- Gateway arkasındaki servislerden biri kapandığında ve Gateway `504 Gateway Timeout` döndüğünde, frontend interceptor katmanımızda hangi mikroservisin çöktüğünü dinamik olarak nasıl teşhis edebiliriz?

## Yarın standup'ta sormak istediğim
- Canlı ortama çıkarken (production) bu `.env` dosyalarını Docker imajı içine gömmek yerine, docker-compose ortam değişkenleriyle nasıl ezebiliriz?
