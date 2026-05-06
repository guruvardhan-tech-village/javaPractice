from pydantic import BaseModel, Field, ConfigDict
from typing import Optional

class SubscriptionBase(BaseModel):
    name: str = Field(..., description="Name of the subscription")
    monthly_cost: float = Field(..., gt=0, description="Monthly cost in USD")
    billing_date: int = Field(..., ge=1, le=31, description="Day of the month the bill is due")
    category: str = Field(..., description="Category (e.g., Entertainment, Software)")

class SubscriptionCreate(SubscriptionBase):
    pass

class SubscriptionUpdate(BaseModel):
    name: Optional[str] = None
    monthly_cost: Optional[float] = None
    billing_date: Optional[int] = None
    category: Optional[str] = None

class SubscriptionOut(SubscriptionBase):
    id: int
    
    model_config = ConfigDict(from_attributes=True)
