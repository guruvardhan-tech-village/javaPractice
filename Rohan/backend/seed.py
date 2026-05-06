import os
import sys
from sqlalchemy.orm import Session
from app.core.database import engine, Base, SessionLocal
from app.models.user import User
from app.models.subscription import Subscription
from app.core.security import get_password_hash

def seed_database():
    Base.metadata.create_all(bind=engine)
    db = SessionLocal()
    try:
        # Check if test user exists
        test_email = "test@example.com"
        user = db.query(User).filter(User.email == test_email).first()
        
        if not user:
            print("Creating test user...")
            hashed_pw = get_password_hash("password123")
            user = User(email=test_email, hashed_password=hashed_pw)
            db.add(user)
            db.commit()
            db.refresh(user)
            print(f"Test user created: {test_email} (password: password123)")
        
        # Check if subscriptions exist for this user
        existing_subs = db.query(Subscription).filter(Subscription.user_id == user.id).count()
        if existing_subs == 0:
            print("Creating mock subscriptions...")
            mock_subscriptions = [
                Subscription(name="Netflix", monthly_cost=15.99, billing_date=1, category="Entertainment", user_id=user.id),
                Subscription(name="Spotify", monthly_cost=9.99, billing_date=5, category="Entertainment", user_id=user.id),
                Subscription(name="Internet", monthly_cost=59.99, billing_date=10, category="Utilities", user_id=user.id),
                Subscription(name="Gym", monthly_cost=45.00, billing_date=15, category="Health", user_id=user.id),
                Subscription(name="AWS", monthly_cost=25.50, billing_date=2, category="Software", user_id=user.id),
            ]
            db.add_all(mock_subscriptions)
            db.commit()
            print("Mock subscriptions added successfully!")
        else:
            print("Subscriptions already exist for the test user. Skipping.")
            
    finally:
        db.close()

if __name__ == "__main__":
    seed_database()
