# Finance Tracker Frontend

This directory contains the React frontend for the application. It provides a polished, interactive, and responsive user interface for managing subscriptions and viewing analytics.

## Tech Stack
- **Vite**: A lightning-fast frontend build tool and development server.
- **React**: A JavaScript library for building user interfaces.
- **TypeScript**: Adds static typing to JavaScript for improved developer experience and code reliability.
- **Tailwind CSS v4**: A utility-first CSS framework for rapid UI development.
- **Recharts**: A composable charting library built on React components.
- **Lucide React**: A beautiful and consistent icon toolkit.

## File Structure & Explanations

- **`src/main.tsx`**: The entry point of the React application. It hooks React into the standard HTML `index.html` file.
- **`src/App.tsx`**: The main layout component. It orchestrates the fetching of data (stats, upcoming bills, subscriptions) and passes that data down to the respective child components. It also renders the top navigation header.
- **`src/index.css`**: The main stylesheet. Since we are using Tailwind v4, this file contains the minimal setup required (`@import "tailwindcss";`) and our global CSS variables (like theme colors and background colors).
- **`src/lib/api.ts`**: A utility file containing all the asynchronous `fetch` functions that communicate with our Python backend. Centralizing this makes API calls easy to manage.
- **`src/lib/utils.ts`**: Contains utility functions, most notably the `cn` function which safely merges Tailwind CSS classes using `clsx` and `tailwind-merge`.
- **`src/types/index.ts`**: Houses all the global TypeScript interfaces (e.g., `Subscription`, `DashboardStats`) used across the application to ensure type safety.
- **`src/components/ui/`**: Contains generic, reusable UI components built using standard HTML and Tailwind CSS (e.g., `button.tsx`, `card.tsx`). These are designed to be agnostic of the app's business logic.
- **`src/components/dashboard/`**: Contains components specific to the top analytics section of the app.
  - `DashboardStats.tsx`: A simple card displaying the total monthly spend.
  - `SpendChart.tsx`: Uses `Recharts` to render the dynamic donut chart visualizing costs broken down by category.
  - `UpcomingBillsAlert.tsx`: A conditional banner that calculates and displays subscriptions due in the next 7 days.
- **`src/components/subscriptions/`**: Contains components specific to subscription management.
  - `SubscriptionList.tsx`: Renders the main table of subscriptions. It includes a toggleable form to add new subscriptions and handles the delete functionality.

## Main Changes We Can Do (Future Enhancements)
- **State Management**: Integrate tools like React Query or Redux. Right now, state is handled in `App.tsx`, but as the app grows, React Query would drastically improve data fetching, caching, and loading states.
- **Edit Functionality**: Expand the `SubscriptionList` to allow inline editing or opening a modal to update existing subscription details (currently it only supports Add and Delete).
- **Dark Mode**: Utilize Tailwind's built-in dark mode capabilities to provide a toggleable dark theme for the UI.
- **Currency Localization**: Update the UI and utility functions to allow users to select their preferred currency format (e.g., EUR, GBP, INR) instead of hardcoding the `$` symbol.
