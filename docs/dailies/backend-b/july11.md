# Gün 4 - Spring Data JPA, Store entity ve Oracle bağlantısı

## Bugün ne yaptım
STORE tablosuna bağlanan Store entity + StoreJpaRepository yazdım. application.yaml'da store_app kullanıcısıyla Oracle bağlantısını açtım (DataSource/Redis exclude'larını kaldırdım). Endpoint'leri in-memory listeden DB'ye geçirdim. StoreDataLoader ile İstanbul'a dağılmış 15 gerçekçi bayiyi seed ettim. city/district filtreli GET /stores sorgusunu ekledim.

## Ne anladım
JPA, Java sınıfını tablo satırına eşler; repository arayüzü sayesinde SQL yazmadan findAll / findById gibi işlemler yapılır. Entity yaşam döngüsü managed/detached/removed durumlarıyla yürür — biz şu an çoğunlukla okuma (managed → DTO) yapıyoruz. Seed data'nın uygulama açılışında bir kez yüklenmesi, Docker init script'inin sadece ilk volume'da çalışması sorununu da çözer.

## Ne anlamadım / kafama takılanlar
- ddl-auto=update ile kolon eklemek prod'da riskli mi; ne zaman Flyway'e geçmeliyiz?
- IgnoreCase city/district filtreleri Oracle'da index'i nasıl etkiler?

## Yarın standup'ta sormak istediğim
Swagger ve ApiError formatını contract ile birebir hizalarken validation hatalarını 400'e nasıl standartlaştırmalıyız?
