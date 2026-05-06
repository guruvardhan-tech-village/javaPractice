import { AlertCircle } from "lucide-react";
import type { Subscription } from "@/types";

interface Props {
  bills: Subscription[];
}

export function UpcomingBillsAlert({ bills }: Props) {
  if (bills.length === 0) return null;

  return (
    <div className="mb-6 rounded-lg border border-amber-200 bg-amber-50 p-4 text-amber-900 shadow-sm transition-all hover:shadow-md">
      <div className="flex items-center gap-2 mb-2">
        <AlertCircle className="h-5 w-5 text-amber-600" />
        <h4 className="font-semibold text-amber-800">Upcoming Bills (Next 7 Days)</h4>
      </div>
      <ul className="list-disc pl-8 text-sm">
        {bills.map((bill) => (
          <li key={bill.id} className="mt-1">
            <span className="font-medium">{bill.name}</span> - ${bill.monthly_cost.toFixed(2)} (Due on the {bill.billing_date}th)
          </li>
        ))}
      </ul>
    </div>
  );
}
