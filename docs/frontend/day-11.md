# Day 11 — Dynamic Pin Styling & Hover Synced Scale

## What I did today
Today I improved the map user experience. I added dynamic color coding to our Leaflet pin markers based on stock levels (Green: `IN_STOCK`, Orange: `LOW`, Red: `OUT_OF_STOCK`). I also implemented hover synchronization. When a user hovers over a store card in the list, the corresponding marker on the map scales up dynamically to draw attention.

## What I learned
- **Lifting State Up:** To sync hover state between the sidebar and the map, I lifted the state (`hoveredStoreId`) to the page components and passed it down to `StoreMap` as a prop.
- **CSS Pin Transitions:** Adding `transition: all 0.15s ease-in-out` inside the Leaflet icon styles made the hover scaling effect smooth and organic.

## Questions & Struggles
- Storing the hovered store ID at the page state level causes frequent re-renders of the map. I need to make sure this doesn't cause lagging issues on slower computers when many markers are active.

## For Tomorrow's Standup
- When we have large numbers of markers, is there a risk of Leaflet lagging on hover, or is the browser performance sufficient?
