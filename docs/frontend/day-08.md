# Day 8 — Browser Geolocation API & Fallback Forms

## What I did today
Today I implemented the Geolocation API (`navigator.geolocation`) to find the user's current coordinates automatically when the app loads. To make the app robust, I also designed a fallback form. If the user denies location permission, the app shows select boxes for City (Istanbul) and District (Kadikoy, Besiktas, Sisli, etc.) to set a default center.

## What I learned
- **Navigator Geolocation:** Learnt that `getCurrentPosition` is asynchronous and requires handling success and error callbacks separately.
- **Robust Fallback Design:** In modern web apps, you cannot assume a user will grant location access. Having fallback coordinates ensures the map is still fully functional and usable.

## Questions & Struggles
- Handling geolocation timeout when the browser GPS takes too long to respond was a bit of a challenge. I had to specify custom timeout option properties in the query parameters.

## For Tomorrow's Standup
- When deploying to staging, should we force HTTPS? Browser geolocation API only works in secure contexts (HTTPS) or localhost.
