# Day 12 — Google Maps Directions Deep Link & TanStack Query

## What I did today
Today I added a "Yol Tarifi Al" button in the store details drawer. It uses the store's latitude and longitude to open a Google Maps navigation deep link. I also refactored our entire API fetching layer to use `@tanstack/react-query` (`useQuery`). This replaced our old manual `useState` and `useEffect` state syncing.

## What I learned
- **Google Maps Navigation Templates:** Deep links format (`https://www.google.com/maps/dir/?api=1&destination=lat,lng`) automatically opens native Google Maps app on mobile or maps tab on desktop.
- **TanStack Query Caching:** Setting a default `staleTime` caches API responses. Now when switching between categories or search parameters, the data loads instantly without showing a spinner if it was already fetched.

## Questions & Struggles
- Getting used to the mental shift from manual lifecycle fetches (`useEffect`) to declarative caching took a bit of reading, but the resulting codebase is much cleaner.

## For Tomorrow's Standup
- When we implement the API Gateway, will all services share a single domain, or will we configure multiple gateways?
