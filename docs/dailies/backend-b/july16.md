# Gün 8 - Haversine geo sorgusu (capability)

## Bugün ne yaptım
capability-service domain katmanına DistanceCalculator (Haversine, km, 1 ondalık) ekledim. /capabilities/{type}/stores akışında store detaylarını alıp mesafe hesabı + radius filtresi + mesafeye göre sıralama yaptım. stock-service ile aynı formülü bilinçli olarak tekrarladım — ortak lib çıkarmadık; nedenini günlüğe not düştüm.

## Ne anladım
Haversine, küre üzerinde iki lat/lng arasındaki büyük daire mesafesini verir. MVP'de hesap uygulama katmanında; ileride DB'ye (SDO_GEOMETRY vb.) taşınabilir. Bilinçli kod tekrarı: iki bounded context'i erken bir kütüphaneyle kenetlemek, bağımsız deploy'u zorlaştırır. Timeout'lu RestClient henüz gün 9'da netleşecek ama geo mantığı bugün hazır.

## Ne anlamadım / kafama takılanlar
- Çok sayıda bayi olursa önce DB'de bounding-box, sonra Haversine mi yapılmalı?
- Radius birimi her zaman km mi kalacak, FE metre isterse kim dönüştürür?

## Yarın standup'ta sormak istediğim
GET /stores?ids= toplu endpoint'inin sıralaması ve eksik ID davranışı (sessizce atla vs 404) contract'ta nasıl netleşsin?
