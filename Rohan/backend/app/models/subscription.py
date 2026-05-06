from sqlalchemy import Column, Integer, String, Float
from app.core.database import Base

class Subscription(Base):
    __tablename__ = "subscriptions"

    id = Column(Integer, primary_key=True, index=True)
    name = Column(String, index=True, nullable=False)
    monthly_cost = Column(Float, nullable=False)
    billing_date = Column(Integer, nullable=False)
    category = Column(String, index=True, nullable=False)
    user_id = Column(Integer, index=True, nullable=False)
