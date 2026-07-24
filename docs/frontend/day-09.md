# Day 9 — Axios Client & API Integration

## What I did today
Today I set up our HTTP network layer. I installed Axios and configured three API instances for our backend services: `stockApi` (:8080), `storeApi` (:8081), and `capabilityApi` (:8082). I also implemented a fallback mechanism where if the services are offline, the app displays warning logs and switches back to local mock simulation automatically.

## What I learned
- **Axios Configuration:** Setting up global defaults like `baseURL`, `timeout`, and headers across multiple Axios instances makes managing API connections very clean.
- **Microservices Architecture:** Having separate ports for each service showed me how microservices operate in parallel.

## Questions & Struggles
- Managing independent timeouts for different service endpoints is a bit tricky. If one service is down, I want to make sure it doesn't hang the rest of the application.

## For Tomorrow's Standup
- When we merge next, will we configure CORS headers in the backend to allow requests from `http://localhost:5173`?
