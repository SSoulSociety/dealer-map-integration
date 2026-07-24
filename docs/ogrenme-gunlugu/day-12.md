# Gün 12 — Google Maps Yol Tarifi Linkleri ve TanStack Query Geçişi

## Bugün ne yaptım
Bugün detay çekmecesine bayinin koordinatlarını kullanarak Google Maps üzerinde yol tarifi açan derin link (Directions Deep Link) butonunu ekledim. Ayrıca projenin asenkron veri çekme katmanını `useState` ve `useEffect` karmaşasından kurtarıp, önbellekleme (client-side caching) desteği sunan `@tanstack/react-query` (`useQuery`) kütüphanesine refactor ettim.

## Ne anladım
- **Google Maps Deep Linking:** `https://www.google.com/maps/dir/?api=1&destination=lat,lng` formatının, hem masaüstünde hem de mobil cihazlarda yerel harita uygulamasını doğrudan tetikleyen evrensel bir derin yönlendirme linki olduğunu öğrendim.
- **TanStack Query (React Query) Avantajları:** Asenkron veri durumunu (`data`, `isLoading`, `error`) tek bir hook içinden yönetebildiğimizi, `queryKey` dizisiyle parametre değişikliklerini otomatik takip ettiğini ve veriyi önbelleğe alarak gereksiz API isteklerini engellediğini keşfettim.

## Ne anlamadım / kafama takılanlar
- `@tanstack/react-query` içerisinde cache'lenen verinin taze olup olmadığını belirten `staleTime` ile cache silinme zamanı olan `gcTime` (garbage collection) arasındaki farklar pratikte nasıl yönetilir?

## Yarın standup'ta sormak istediğim
- Stok güncelleme formları yapıldığında cache invalidation (`queryClient.invalidateQueries`) tetiklenerek haritanın anında güncel veriyi çekmesi nasıl tetiklenir?
