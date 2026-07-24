# Day 5 — Store Details Drawer & Demo #1

## What I did today
Today I built the interaction between the map markers and the sidebar. When a user clicks on a marker or a list card, it opens a right-side sliding Drawer containing detailed information about the store (address, working hours, and phone). I also added an Ant Design Skeleton loader inside the Drawer to simulate network latency, and verified the entire setup for our Demo #1.

## What I learned
- **Inter-component Interaction:** Triggering state updates from marker clicks to open the drawer showed me how cleanly data travels back and forth when state is maintained at the page level.
- **UX Latency Simulation:** Using skeletons makes a huge difference. Showing empty loading screens makes the app feel broken, whereas a skeleton loader gives immediate visual confirmation.

## Questions & Struggles
- Getting the drawer to slide out without breaking the map layout took some CSS tweaks. I had to position the drawer absolute with high z-index.

## For Tomorrow's Standup
- Ready for Demo #1! I will showcase search filtering and map pin selection using our mock data.
