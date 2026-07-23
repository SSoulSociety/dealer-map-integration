# Gün 12 - Google Maps deep link ve capability seed

## Bugün ne yaptım
store-service'te bayi koordinatlarından Google Maps yol tarifi deep link'i üreten GoogleMapsDeepLink domain yardımcı sınıfını ekledim; tüm StoreResponse cevaplarına directionsUrl alanını bağladım (maps/dir/?api=1&destination=lat,lng). Aynı formülü capability-service'te bilinçli tekrarlayıp StoreCapabilityResult'a da ekledim. Capability seed'ini zenginleştirdim: TIM bayilerini hub / tamir odaklı / hat-taşıma odaklı gruplara ayırdım, franchise tarafında DEVICE_REPAIR ve DEVICE_DELIVERY dağılımını çeşitlendirdim. API contract'taki Store tipini güncelledim.

## Ne anladım
Deep link, kullanıcıyı harita SDK'sına zorlamadan tarayıcıda Google Maps yol tarifine açar; URL sunucuda üretilince frontend ve Postman aynı sözleşmeyi kullanır. Seed zenginleştirme, filtre demo'larını (ör. DEVICE_REPAIR) daha gerçekçi kılar — her TIM'in her yetkinliğe sahip olması filtre farkını göstermeyi zorlaştırıyordu. Bounded context'ler arasında URL formülünü ortak lib yapmamak, Gün 8 geo tekrarıyla aynı gerekçeye dayanıyor.

## Ne anlamadım / kafama takılanlar
- Mevcut Oracle'da eski seed varsa loader skip ediyor; zenginleştirilmiş seed'i canlı DB'ye yansıtmak için truncate mu, migration mu tercih edilmeli?
- directionsUrl stock-service cevaplarına da mı eklenmeli, yoksa sadece store/capability yeterli mi?

## Yarın standup'ta sormak istediğim
Gateway route prefix'lerini (/api/pasaj, /api/stores, /api/comtr) ve StripPrefix stratejisini Backend A ile birlikte netleştirelim; CORS'u hangi origin listesiyle gateway'e taşıyacağız?
