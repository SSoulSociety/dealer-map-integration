# Gün 6 - DDD katmanları ve capability-service iskeleti

## Bugün ne yaptım
store-service'i domain / application / infrastructure / presentation paketlerine refactor ettim. Store aggregate + StoreStatus/StoreType domain'de; JPA entity altyapıda kaldı. Backend A ile birlikte whiteboard'ta bounded context konuştuk. Ardından capability-service Spring Boot iskeletini port 8082'de açtım (henüz endpoint yok / yarın filtreleme).

## Ne anladım
store-service "bayi kimdir" bağlamı; capability-service "bu işlemi kim yapar" bağlamı. İkisi de Store kavramını kullanır ama capability yalnızca storeId tutar — detayı store-service'ten ister. Bu, shared kernel / published language yerine "veriyi sahibinden iste" pratiği. Katmanlar sayesinde controller Haversine veya JPA bilmek zorunda kalmıyor.

## Ne anlamadım / kafama takılanlar
- İki servis aynı Oracle kullanıcısını (store_app) paylaşmak bounded context sınırını zayıflatır mı?
- Domain model ile JPA entity'yi her zaman ayrı tutmak abartı mı, yoksa staj ölçeğinde şart mı?

## Yarın standup'ta sormak istediğim
workingHours=weekend ve status=ACTIVE filtrelerini STORE tablosuna kolon olarak mı ekleyelim, yoksa ayrı bir VIEW/projection mı?
