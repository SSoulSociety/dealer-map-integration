# Day 13 — Spring Cloud Gateway Entegrasyonu & Environment Configurations (.env)

## What I did today
Today I integrated the frontend with the Spring Cloud Gateway setup (running on port `8085`). I created an environment config file (`.env`) and defined `VITE_API_GATEWAY_URL`. I updated our Axios client (`client.ts`) to route all requests through this single entry point instead of hitting direct microservice ports, with automatic fallback support.

## What I learned
- **API Gateways:** Gateways provide a single endpoint for all microservices. It simplifies the client configurations since we only have to specify one host URL.
- **Vite Env Variables:** Vite variables must have the `VITE_` prefix and are loaded securely in the client using `import.meta.env`.

## Questions & Struggles
- When routing through the gateway, I had to ensure that the path prefixes (e.g. `/api/pasaj/` for stock service) matched the gateway routes exactly.

## For Tomorrow's Standup
- When we package the app into a Docker container, how will we pass different `.env` configurations (e.g. for staging vs production environments)?
