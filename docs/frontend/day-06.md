# Day 6 — BEM SCSS & Component Refactoring

## What I did today
Today was refactoring day. I took the inline styles and disorganized CSS blocks and refactored them using SASS with the BEM (Block-Element-Modifier) naming convention. I also extracted reusable interface components, such as `StoreCard`, so they can be shared between the Pasaj and Transactions pages.

## What I learned
- **BEM Methodology:** BEM (like `.locator-sidebar__filter-group--active`) makes styles scoped and readable. It prevents style leakage where CSS in one file unexpectedly breaks formatting in another.
- **Atomic Refactoring:** Extracting components helps keep the page-level code smaller and easier to maintain. Now `StoreCard` takes props and doesn't care about business logic.

## Questions & Struggles
- Converting relative styles to BEM SCSS required careful class mapping. I broke some button borders temporarily but resolved them.

## For Tomorrow's Standup
- Should we define a central brand colors file in SCSS (e.g. `_variables.scss`) so that we can change styles globally?
