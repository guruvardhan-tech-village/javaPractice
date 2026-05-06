# Finance Tracker Backend

This directory contains the Python FastAPI backend for the application. It provides the RESTful API endpoints necessary for managing subscriptions and calculating dashboard analytics.

## Tech Stack
- **FastAPI**: A modern, fast web framework for building APIs with Python.
- **SQLAlchemy**: The Python SQL toolkit and Object-Relational Mapper (ORM).
- **SQLite**: A lightweight, serverless database engine (requires zero configuration).
- **Pydantic**: Data validation and settings management using Python type hints.

## File Structure & Explanations

- **`app/main.py`**: The entry point of the FastAPI application. It initializes the app, configures CORS, creates the database tables, and registers the API routers.
- **`app/core/database.py`**: Handles the database connection logic. It sets up the SQLAlchemy engine, session maker, and provides a `get_db` dependency for routes to access the database session safely.
- **`app/models/subscription.py`**: Defines the SQLAlchemy ORM model for a `Subscription`. This dictates how data is structured as tables and columns in the SQLite database.
- **`app/schemas/subscription.py`**: Contains Pydantic models (schemas) used for validating incoming request payloads (e.g., creating/updating) and serializing outgoing API responses.
- **`app/services/subscription_service.py`**: Contains the core business logic and database queries for CRUD operations. It acts as an intermediary between the routes and the database to keep the routing layer clean.
- **`app/api/routes/subscriptions.py`**: Defines the HTTP endpoints (`GET`, `POST`, `PUT`, `DELETE`) specifically for managing user subscriptions.
- **`app/api/routes/analytics.py`**: Defines the HTTP endpoints used for the dashboard, such as calculating the total monthly spend, category breakdowns, and determining upcoming bills.

## Main Changes We Can Do (Future Enhancements)
- **Authentication & Authorization**: Implement JWT (JSON Web Tokens) to allow multiple users to register, login, and have their own isolated subscription data.
- **Database Migrations**: Integrate `Alembic` to handle database schema migrations gracefully as the application grows (e.g., if we want to add new columns to the `Subscription` table later).
- **Advanced Filtering & Pagination**: Add query parameters to the `GET /subscriptions` endpoint to allow the frontend to filter by category, sort by price, or paginate large amounts of data.
- **Cron Jobs**: Implement background tasks (using tools like Celery or APScheduler) to automatically send email notifications when a bill is due.
