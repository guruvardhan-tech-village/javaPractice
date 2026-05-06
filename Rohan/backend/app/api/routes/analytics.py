from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session
from sqlalchemy import func
from datetime import datetime, timedelta
from typing import Dict, Any, List

from app.core.database import get_db
from app.models.subscription import Subscription
from app.api.deps import get_current_user
from app.models.user import User

router = APIRouter()

@router.get("/dashboard")
def get_dashboard_analytics(db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    # Calculate total monthly spend
    total_spend = db.query(func.sum(Subscription.monthly_cost)).filter(Subscription.user_id == current_user.id).scalar() or 0.0
    
    # Calculate spend by category
    category_spend_query = db.query(
        Subscription.category, 
        func.sum(Subscription.monthly_cost).label("total")
    ).filter(Subscription.user_id == current_user.id).group_by(Subscription.category).all()
    
    category_breakdown = [
        {"name": row.category, "value": float(row.total)}
        for row in category_spend_query
    ]
    
    return {
        "total_monthly_spend": float(total_spend),
        "category_breakdown": category_breakdown
    }

@router.get("/upcoming")
def get_upcoming_bills(db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    """Get bills due in the next 7 days"""
    today = datetime.now()
    upcoming_limit = today + timedelta(days=7)
    
    current_day = today.day
    limit_day = upcoming_limit.day
    
    subscriptions = db.query(Subscription).filter(Subscription.user_id == current_user.id).all()
    upcoming = []
    
    for sub in subscriptions:
        bill_date = sub.billing_date
        is_due = False
        if limit_day >= current_day:
            is_due = current_day <= bill_date <= limit_day
        else:
            is_due = bill_date >= current_day or bill_date <= limit_day
            
        if is_due:
            upcoming.append({
                "id": sub.id,
                "name": sub.name,
                "monthly_cost": sub.monthly_cost,
                "billing_date": sub.billing_date
            })
            
    return upcoming
