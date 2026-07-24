# Day 1 — Project Kickoff & TypeScript Models

## What I did today
Today was our first day of the internship. The backend team and I met up to design the API Contract so we could start working in parallel without waiting on each other. After that, I initialized our frontend app using Vite, React, and TypeScript. I also declared the initial TypeScript types and interfaces (`Product`, `Store`, `StockLevel`, etc.) based on our agreed contract.

## What I learned
- **Vite & SPA:** Vite is incredibly fast compared to old tools like Create React App. SPA (Single Page Application) works by serving a single HTML file and rendering components dynamically via client-side routing.
- **Contract First:** Writing down the types first acts as a guide. It makes it clear what fields the backend will send so I can design mock data easily.

## Questions & Struggles
- I had some minor TypeScript compilation errors in my configuration file (`tsconfig.json`) when importing Vite-specific env variables, but managed to sort it out after searching.

## For Tomorrow's Standup
- Do we expect any new transaction capability types to be added to the enum later on, or should I stick strictly to the current 5 types?
