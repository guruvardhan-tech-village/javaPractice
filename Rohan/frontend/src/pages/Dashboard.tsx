import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import type { DashboardStats as DashboardStatsType, Subscription } from "@/types";
import { fetchDashboardStats, fetchUpcomingBills, fetchSubscriptions, createSubscription, deleteSubscription } from "@/lib/api";
import { DashboardStats } from "@/components/dashboard/DashboardStats";
import { SpendChart } from "@/components/dashboard/SpendChart";
import { UpcomingBillsAlert } from "@/components/dashboard/UpcomingBillsAlert";
import { SubscriptionList } from "@/components/subscriptions/SubscriptionList";
import { Wallet, LogOut } from "lucide-react";
import { useAuth } from "@/contexts/AuthContext";
import { ThemeToggle } from "@/components/ThemeToggle";
import { Button } from "@/components/ui/button";

export function Dashboard() {
  const [stats, setStats] = useState<DashboardStatsType | null>(null);
  const [upcomingBills, setUpcomingBills] = useState<Subscription[]>([]);
  const [subscriptions, setSubscriptions] = useState<Subscription[]>([]);
  const [loading, setLoading] = useState(true);
  const { logout } = useAuth();
  const navigate = useNavigate();

  const loadData = async () => {
    try {
      setLoading(true);
      const [statsData, upcomingData, subsData] = await Promise.all([
        fetchDashboardStats(),
        fetchUpcomingBills(),
        fetchSubscriptions(),
      ]);
      setStats(statsData);
      setUpcomingBills(upcomingData);
      setSubscriptions(subsData);
    } catch (error) {
      console.error("Failed to load data", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadData();
  }, []);

  const handleAdd = async (data: Omit<Subscription, "id">) => {
    try {
      await createSubscription(data);
      loadData();
    } catch (error) {
      console.error(error);
    }
  };

  const handleDelete = async (id: number) => {
    try {
      await deleteSubscription(id);
      loadData();
    } catch (error) {
      console.error(error);
    }
  };

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <div className="min-h-screen bg-slate-50 text-slate-900 font-sans dark:bg-slate-950 dark:text-slate-50">
      <header className="border-b border-slate-200 bg-white sticky top-0 z-10 shadow-sm dark:border-slate-800 dark:bg-slate-900">
        <div className="mx-auto flex h-16 max-w-5xl items-center justify-between px-4 sm:px-6 lg:px-8">
          <div className="flex items-center">
            <Wallet className="mr-2 h-6 w-6 text-primary" />
            <h1 className="text-xl font-bold tracking-tight text-slate-900 dark:text-slate-50">Finance Tracker</h1>
          </div>
          <div className="flex items-center gap-4">
            <ThemeToggle />
            <Button variant="ghost" onClick={handleLogout} className="text-slate-600 hover:text-slate-900 dark:text-slate-400 dark:hover:text-slate-50">
              <LogOut className="h-4 w-4 mr-2" />
              Logout
            </Button>
          </div>
        </div>
      </header>

      <main className="mx-auto max-w-5xl px-4 py-8 sm:px-6 lg:px-8">
        {loading ? (
          <div className="flex h-64 items-center justify-center">
            <div className="h-8 w-8 animate-spin rounded-full border-4 border-primary border-t-transparent"></div>
          </div>
        ) : (
          <div className="animate-in fade-in duration-500">
            <UpcomingBillsAlert bills={upcomingBills} />
            
            <div className="grid gap-6 md:grid-cols-3">
              {stats && (
                <>
                  <div className="md:col-span-1">
                    <DashboardStats totalSpend={stats.total_monthly_spend} />
                  </div>
                  <div className="md:col-span-2">
                    <SpendChart data={stats.category_breakdown} />
                  </div>
                </>
              )}
            </div>

            <SubscriptionList 
              subscriptions={subscriptions} 
              onAdd={handleAdd} 
              onDelete={handleDelete} 
            />
          </div>
        )}
      </main>
    </div>
  );
}
