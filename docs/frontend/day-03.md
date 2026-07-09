# Day 3 — Mock Data & Pasaj Search Filters

## What I did today
Today I created our local mock data (`mockData.ts`) using the types defined on Day 1. This contains mock products, stores, and stocks. Then, on the `/pasaj` page, I built the sidebar UI. I added search dropdowns for categories, brands, and specific products. I connected these filters to a local React state to dynamically list matching stores based on the selections.

## What I learned
- **React State & Rerendering:** Understood how changing the selected dropdown value triggers a state update, which in turn causes React to recalculate the filtered store list and update the DOM automatically.
- **Data Modeling for UI:** Structuring the stock mock data in a dictionary map format (e.g. `productId-storeId` key) made stock queries much cleaner than looping through arrays every time.

## Questions & Struggles
- Keeping filters in sync was a bit annoying. For example, when changing the category, I had to reset the selected brand and product to avoid showing invalid states.

## For Tomorrow's Standup
- When a product is out of stock everywhere, should the UI show an Empty state warning or still list the nearest stores but with a red "Out of Stock" status label?
