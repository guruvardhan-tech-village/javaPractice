export interface Subscription {
  id: int;
  name: string;
  monthly_cost: number;
  billing_date: number;
  category: string;
}

export interface DashboardStats {
  total_monthly_spend: number;
  category_breakdown: { name: string; value: number }[];
}
