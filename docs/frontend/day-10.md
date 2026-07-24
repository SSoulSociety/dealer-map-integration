# Day 10 — CORS Error Handling & Demo #2

## What I did today
Today was integration and Demo #2 day. We connected the frontend to the real backend microservices. I implemented Axios response interceptors to catch CORS preflight blockages and network failures. When a connection fails, it now shows a notification alert to the user instead of failing silently.

## What I learned
- **CORS (Cross-Origin Resource Sharing):** Understood why browsers block cross-origin requests by default for security, the preflight `OPTIONS` request flow, and how backend `@CrossOrigin` configs allow frontend domains to read response data.
- **Axios Interceptors:** Using interceptors to catch errors globally helps keep page code dry and lets us trigger shared toast messages easily.

## Questions & Struggles
- Resolving the initial preflight check errors required coordinating with both backend stajyers to configure their Spring Boot controllers correctly.

## For Tomorrow's Standup
- Ready for Demo #2! I will show the end-to-end integration: querying products and capabilities from the live backend services and rendering pins.
