import { useState } from "react";
import type { Subscription } from "@/types";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Plus, Trash2 } from "lucide-react";

interface Props {
  subscriptions: Subscription[];
  onDelete: (id: number) => void;
  onAdd: (sub: Omit<Subscription, "id">) => void;
}

export function SubscriptionList({ subscriptions, onDelete, onAdd }: Props) {
  const [isAdding, setIsAdding] = useState(false);
  const [formData, setFormData] = useState({ name: "", monthly_cost: "", billing_date: "", category: "" });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onAdd({
      name: formData.name,
      monthly_cost: parseFloat(formData.monthly_cost),
      billing_date: parseInt(formData.billing_date),
      category: formData.category || "General",
    });
    setIsAdding(false);
    setFormData({ name: "", monthly_cost: "", billing_date: "", category: "" });
  };

  return (
    <Card className="mt-8">
      <CardHeader className="flex flex-row items-center justify-between">
        <CardTitle>Your Subscriptions</CardTitle>
        <Button onClick={() => setIsAdding(!isAdding)} className="flex items-center gap-2">
          <Plus className="h-4 w-4" /> Add New
        </Button>
      </CardHeader>
      <CardContent>
        {isAdding && (
          <form onSubmit={handleSubmit} className="mb-6 grid grid-cols-1 gap-4 rounded-lg bg-slate-50 p-4 sm:grid-cols-5 border border-slate-200">
            <input required placeholder="Name" className="rounded border px-3 py-2 text-sm" value={formData.name} onChange={e => setFormData({ ...formData, name: e.target.value })} />
            <input required type="number" step="0.01" min="0" placeholder="Cost ($)" className="rounded border px-3 py-2 text-sm" value={formData.monthly_cost} onChange={e => setFormData({ ...formData, monthly_cost: e.target.value })} />
            <input required type="number" min="1" max="31" placeholder="Bill Date (1-31)" className="rounded border px-3 py-2 text-sm" value={formData.billing_date} onChange={e => setFormData({ ...formData, billing_date: e.target.value })} />
            <select required className="rounded border px-3 py-2 text-sm bg-white" value={formData.category} onChange={e => setFormData({ ...formData, category: e.target.value })}>
              <option value="" disabled>Category</option>
              <option value="Entertainment">Entertainment</option>
              <option value="Software">Software</option>
              <option value="Utilities">Utilities</option>
              <option value="Health">Health</option>
              <option value="Other">Other</option>
            </select>
            <div className="flex gap-2">
              <Button type="submit" className="w-full">Save</Button>
              <Button type="button" variant="outline" onClick={() => setIsAdding(false)}>Cancel</Button>
            </div>
          </form>
        )}

        <div className="overflow-x-auto">
          <table className="w-full text-left text-sm">
            <thead className="bg-slate-50 text-slate-500">
              <tr>
                <th className="px-4 py-3 font-medium rounded-tl-lg">Name</th>
                <th className="px-4 py-3 font-medium">Category</th>
                <th className="px-4 py-3 font-medium">Cost</th>
                <th className="px-4 py-3 font-medium">Billing Date</th>
                <th className="px-4 py-3 font-medium rounded-tr-lg text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-100">
              {subscriptions.length === 0 ? (
                <tr>
                  <td colSpan={5} className="py-8 text-center text-slate-500">No subscriptions found. Add one to get started!</td>
                </tr>
              ) : (
                subscriptions.map(sub => (
                  <tr key={sub.id} className="hover:bg-slate-50/50 transition-colors">
                    <td className="px-4 py-3 font-medium text-slate-900">{sub.name}</td>
                    <td className="px-4 py-3">
                      <span className="inline-flex items-center rounded-full bg-blue-50 px-2 py-1 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10">
                        {sub.category}
                      </span>
                    </td>
                    <td className="px-4 py-3">${sub.monthly_cost.toFixed(2)}</td>
                    <td className="px-4 py-3">Day {sub.billing_date}</td>
                    <td className="px-4 py-3 text-right">
                      <Button variant="ghost" onClick={() => onDelete(sub.id)} className="h-8 w-8 p-0 text-red-500 hover:text-red-700 hover:bg-red-50">
                        <Trash2 className="h-4 w-4" />
                      </Button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </CardContent>
    </Card>
  );
}
