# Gün 11 — Gelişmiş Harita UX, Dinamik Marker Renkleri ve Hover Senkronizasyonu

## Bugün ne yaptım
Bugün Pasaj ve İşlemler sayfalarındaki harita deneyimini geliştirdim. Harita üzerindeki pinleri (Marker) ürün stok seviyesine göre dinamik olarak renklendirdim (yeşil, sarı ve kırmızı). Yan listedeki bir bayi kartının üzerine gelindiğinde (hover), harita üzerindeki ilgili pini ölçekleyen (büyüten) ve vurgulayan state senkronizasyonunu (Lifting State Up prensibiyle) uyguladım.

## Ne anladım
- **Lifting State Up (State Vurgulama):** Kardeş bileşenler (StoreCard listesi ve StoreMap) arasında hover durumunu paylaşmak için state'i ortak ebeveyne (`Pasaj.tsx` / `Transactions.tsx`) taşıyıp, aşağı prop olarak aktarmanın React'in tek yönlü veri akışıyla ne kadar uyumlu olduğunu gördüm.
- **Dinamik Leaflet Özelleştirme:** Leaflet'in `L.divIcon` fonksiyonu sayesinde inline CSS ve CSS değişkenleri kullanarak harita üzerinde DOM elementleri oluşturup bunlara kolayca geçiş animasyonları (`transition: all 0.15s ease-in-out`) atayabildiğimizi anladım.

## Ne anlamadım / kafama takılanlar
- Harita üzerinde aynı anda yüzlerce bayi görüntülendiğinde, her hover tetiklenmesinde ebeveyn bileşenin yeniden render (re-render) olması performans kaybına yol açar mı?

## Yarın standup'ta sormak istediğim
- Bayi sayısı arttığında performansı korumak için `React.memo` kullanmalı mıyız, yoksa Leaflet performansı varsayılan olarak yeterli midir?
