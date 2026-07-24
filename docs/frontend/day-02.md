# Day 2 — Routing & Layout Structure

## What I did today
Today I set up the foundation of the app's user interface. I installed React Router and created the page shell. I set up two main routes: `/pasaj` for product stock searches and `/transactions` (or `/islemler`) for business capabilities. I also integrated Ant Design to quickly build a responsive Layout, adding a main navbar and footer.

## What I learned
- **React Router:** Understood how `<BrowserRouter>`, `<Routes>`, and `<Route>` work together. Client-side routing is instantaneous because it doesn't request a new HTML page from a server.
- **Ant Design Components:** Used `Layout`, `Menu`, and basic structural styles. It saves a lot of time compared to writing custom navigation from scratch, though styling overrides can be tricky.

## Questions & Struggles
- Overriding Ant Design's default CSS variables for our brand colors (Turkcell Blue) took some time because of specificity rules in CSS. I need to make sure I'm doing this the clean way.

## For Tomorrow's Standup
- Should the default landing page (`/`) redirect directly to the Pasaj page, or should we keep a simple dashboard dashboard to select which page to go to?
