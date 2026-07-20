# Gün 7 - Parametreli filtreleme (capability)

## Bugün ne yaptım
GET /capabilities/{type}/stores endpoint'ine workingHours=weekend ve status=ACTIVE query parametrelerini ekledim. STORE tablosuna status + opens_weekend kolonlarını ekleyip seed'i genişlettim (ör. Fatih Franchise INACTIVE, bazı bayiler hafta sonu kapalı). STORE_CAPABILITY seed'ini mockStoreCapabilities ile hizaladım. GET /capabilities/types dropdown listesini yazdım.

## Ne anladım
CapabilityType bir enum / value-like kavram; DB'de string olarak saklanıp domain'de tipe çevriliyor. Filtre parametreleri "her şeyi frontend'de ele" yerine sunucuda uygulanınca ağ trafiği ve tutarlılık kazanıyor. Seed modellemesi genişleyince demo senaryoları (aktif + hafta sonu açık) gerçekçi hale geliyor.

## Ne anlamadım / kafama takılanlar
- workingHours için serbest text mi, yoksa weekend/weekday gibi kapalı bir enum seti mi contract'a yazılmalı?
- status filtresi default ACTIVE mi olmalı, yoksa parametre yoksa tüm statusler mi?

## Yarın standup'ta sormak istediğim
Geo (lat/lng/radius) hesabını capability içinde mi tutacağız, yoksa ortak bir geo-lib modülüne mi çıkaracağız? (Plan bilinçli tekrarı öneriyor.)
