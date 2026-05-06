# Personal Finance & Subscription Tracker

A full-stack web application designed to help users track their recurring subscriptions, visualize their monthly spending, and get alerted about upcoming bills. 

This project serves as a highly polished resume portfolio piece, featuring a responsive, dynamic user interface and a robust REST API.

## Project Structure

The repository is thoughtfully split into two independent parts to separate concerns:
- **`backend/`**: A high-performance Python FastAPI backend utilizing SQLite and SQLAlchemy for data persistence.
- **`frontend/`**: A modern React frontend powered by Vite, TypeScript, and styled with Tailwind CSS V4.

> **Note:** Please see `backend/README.md` and `frontend/README.md` for deep dives into their respective architectures, file-by-file explanations, and potential future enhancements.

## Core Features
1. **Subscription CRUD**: Users can Add, Read, and Delete recurring subscriptions with details like cost, billing date, and category.
2. **Dashboard Analytics**: A summary showing "Total Monthly Spend" and an interactive donut chart breaking down costs by category.
3. **Upcoming Bills Alert**: A smart feature that automatically calculates and highlights subscriptions renewing within the next 7 days.

---

## Getting Started

### Prerequisites
Ensure you have the following installed on your machine:
- Node.js (v18+)
- Python (3.10+)

### 1. Running the Backend
The backend runs on a lightweight SQLite database, so no external database installation is required!

1. Open a terminal and navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Activate the virtual environment:
   - **Windows (PowerShell):** `.\venv\Scripts\Activate.ps1`
   - **Mac/Linux:** `source venv/bin/activate`
3. Run the development server:
   ```bash
   uvicorn app.main:app --reload --port 8000
   ```
4. The API is now running at `http://localhost:8000`. You can view the automatic Swagger UI documentation by navigating to `http://localhost:8000/docs` in your browser.

### 2. Running the Frontend
1. Open a *new* terminal window and navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies (if you haven't already):
   ```bash
   npm install
   ```
3. Run the Vite development server:
   ```bash
   npm run dev
   ```
4. Open your browser and navigate to `http://localhost:5173` to view the live application!
