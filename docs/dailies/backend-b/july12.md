# Gün 5 - Swagger, validation ve hata yönetimi

## Bugün ne yaptım
springdoc-openapi ekleyip /swagger-ui.html üzerinden store-service endpoint'lerini dokümante ettim. @Validated + @Positive ile path parametre doğrulaması ekledim. GlobalExceptionHandler'ı StoreNotFoundException (404) ve ConstraintViolationException (400) için ApiError formatında güncelledim. Demo #1 için Postman collection'ı Swagger ile çapraz kontrol ettim.

## Ne anladım
Entity'yi doğrudan JSON olarak dönmek yerine DTO (StoreResponse) kullanıyoruz — böylece persistence detayları (status kolon adı vb.) API sözleşmesinden ayrılıyor. Swagger, FE ve diğer servislerin "ne beklemeli" sorusunun canlı dokümanı. Validation kurallarının controller'da annotation ile durması, iş kuralını domain'e bırakıp HTTP sınırını ince tutuyor.

## Ne anlamadım / kafama takılanlar
- springdoc versiyonu Spring Boot ile nasıl hizalanmalı; major upgrade'lerde UI path neden değişiyor?
- NumberFormatException'ı ids=abc,def gibi toplu sorguda da aynı ApiError ile mi yakalamalıyız?

## Yarın standup'ta sormak istediğim
capability-service iskeletini ayrı repo/modül mü açıyoruz, yoksa monorepo içinde yan klasör mü yeterli?
