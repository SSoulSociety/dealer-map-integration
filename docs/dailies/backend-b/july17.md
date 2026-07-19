# Gün 9 - GET /stores?ids= ve servisler arası RestClient

## Bugün ne yaptım
store-service'e stock/capability'nin ihtiyaç duyduğu GET /stores?ids=1,5,9 toplu sorgusunu ekledim; Swagger'ı güncelledim. capability-service içinde StoreServiceClient (RestClient, connect/read timeout) yazdım — yetkin storeId listesini aldıktan sonra detayları bu endpoint'ten çekiyor. store-service down ise 503 + ApiError dönüyor. Postman collection'ları her iki servis için güncellendi.

## Ne anladım
Senkron HTTP çağrısında timeout hayati: karşı taraf yavaşlarsa thread'ler dolup kendi servisini de düşürür. Sözleşme değişikliği (yeni query şekli) Swagger + Postman + günlük ile üç yerde aynı anda güncellenmeli. ids ile city/district aynı anda kullanılmaz — controller'da öncelik sırası ids > region > all.

## Ne anlamadım / kafama takılanlar
- Circuit breaker (Resilience4j) bu ölçekte şart mı, yoksa timeout yeterli mi?
- API versiyonlama (/v1) ne zaman gerekir; query eklemek breaking change sayılır mı?

## Yarın standup'ta sormak istediğim
Gün 10 entegrasyonunda CORS'u her serviste mi açacağız, yoksa doğrudan Gateway'e mi erteleyeceğiz?
