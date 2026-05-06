from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from typing import List

from app.core.database import get_db
from app.schemas.subscription import SubscriptionOut, SubscriptionCreate, SubscriptionUpdate
from app.services import subscription_service
from app.api.deps import get_current_user
from app.models.user import User
from app.models.subscription import Subscription

router = APIRouter()

@router.get("/", response_model=List[SubscriptionOut])
def read_subscriptions(db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    return db.query(Subscription).filter(Subscription.user_id == current_user.id).all()

@router.get("/{subscription_id}", response_model=SubscriptionOut)
def read_subscription(subscription_id: int, db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    db_subscription = db.query(Subscription).filter(Subscription.id == subscription_id, Subscription.user_id == current_user.id).first()
    if db_subscription is None:
        raise HTTPException(status_code=404, detail="Subscription not found")
    return db_subscription

@router.post("/", response_model=SubscriptionOut, status_code=status.HTTP_201_CREATED)
def create_subscription(subscription: SubscriptionCreate, db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    db_subscription = Subscription(**subscription.model_dump(), user_id=current_user.id)
    db.add(db_subscription)
    db.commit()
    db.refresh(db_subscription)
    return db_subscription

@router.put("/{subscription_id}", response_model=SubscriptionOut)
def update_subscription(subscription_id: int, subscription: SubscriptionUpdate, db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    db_subscription = db.query(Subscription).filter(Subscription.id == subscription_id, Subscription.user_id == current_user.id).first()
    if db_subscription is None:
        raise HTTPException(status_code=404, detail="Subscription not found")
    
    update_data = subscription.model_dump(exclude_unset=True)
    for key, value in update_data.items():
        setattr(db_subscription, key, value)
        
    db.commit()
    db.refresh(db_subscription)
    return db_subscription

@router.delete("/{subscription_id}", response_model=SubscriptionOut)
def delete_subscription(subscription_id: int, db: Session = Depends(get_db), current_user: User = Depends(get_current_user)):
    db_subscription = db.query(Subscription).filter(Subscription.id == subscription_id, Subscription.user_id == current_user.id).first()
    if db_subscription is None:
        raise HTTPException(status_code=404, detail="Subscription not found")
        
    db.delete(db_subscription)
    db.commit()
    return db_subscription
