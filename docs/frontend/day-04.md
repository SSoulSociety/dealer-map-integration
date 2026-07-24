# Day 4 — Map Integration & Leaflet Markers

## What I did today
Today I worked on the map integration. We decided to use Leaflet via `react-leaflet` since we didn't want to get blocked by Google Maps API key requirements during local testing. I set up the `<MapContainer>` centered on Istanbul and added a tile layer. I fetched the coordinate data from our mock stores list and successfully rendered them on the map as pin markers.

## What I learned
- **Leaflet & OpenStreetMap:** React Leaflet wrapper works by binding leaflet DOM events to React lifecycle hooks. OSM tiles are loaded on demand based on the zoom and coordinates.
- **Custom Marker Icons:** Learnt how to customize marker icons using Leaflet's `L.divIcon` so we can style them with HTML/CSS rather than relying on default blue images.

## Questions & Struggles
- React Leaflet sometimes doesn't update its center dynamically when the parent coords change. I had to write a helper component (`RecenterMap`) that grabs the map instance using `useMap()` and calls `setView` manually.

## For Tomorrow's Standup
- When we move to the real backend, will the store coordinates always be in double format (latitude/longitude), and does the backend validate that the points are within Turkey boundaries?
