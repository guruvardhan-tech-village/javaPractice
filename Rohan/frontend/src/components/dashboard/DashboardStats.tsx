import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { DollarSign } from "lucide-react";

interface Props {
  totalSpend: number;
}

export function DashboardStats({ totalSpend }: Props) {
  return (
    <Card>
      <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
        <CardTitle className="text-sm font-medium">Total Monthly Spend</CardTitle>
        <DollarSign className="h-4 w-4 text-slate-500" />
      </CardHeader>
      <CardContent>
        <div className="text-3xl font-bold text-primary">${totalSpend.toFixed(2)}</div>
        <p className="text-xs text-slate-500">Across all categories</p>
      </CardContent>
    </Card>
  );
}
