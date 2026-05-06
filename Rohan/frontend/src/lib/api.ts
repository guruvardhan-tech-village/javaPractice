import type { Subscription, DashboardStats } from "../types";

const API_BASE_URL = "http://localhost:8000/api";

function getHeaders() {
  const headers: Record<string, string> = { "Content-Type": "application/json" };
  const token = localStorage.getItem("token");
  if (token) {
    headers["Authorization"] = `Bearer ${token}`;
  }
  return headers;
}

async function handleResponse(res: Response) {
  if (!res.ok) {
    if (res.status === 401) {
      localStorage.removeItem("token");
      window.location.href = "/login";
    }
    const err = await res.json().catch(() => ({}));
    throw new Error(err.detail || "API Error");
  }
  return res.json();
}

export async function login(username: string, password: string) {
  const formData = new URLSearchParams();
  formData.append("username", username);
  formData.append("password", password);
  
  const res = await fetch(`${API_BASE_URL}/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: formData,
  });
  return handleResponse(res);
}

export async function register(email: string, password: string) {
  const res = await fetch(`${API_BASE_URL}/auth/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
  });
  return handleResponse(res);
}

export async function fetchUser(): Promise<{ id: number; email: string }> {
  const res = await fetch(`${API_BASE_URL}/auth/me`, { headers: getHeaders() });
  return handleResponse(res);
}

export async function fetchDashboardStats(): Promise<DashboardStats> {
  const res = await fetch(`${API_BASE_URL}/analytics/dashboard`, { headers: getHeaders() });
  return handleResponse(res);
}

export async function fetchUpcomingBills(): Promise<Subscription[]> {
  const res = await fetch(`${API_BASE_URL}/analytics/upcoming`, { headers: getHeaders() });
  return handleResponse(res);
}

export async function fetchSubscriptions(): Promise<Subscription[]> {
  const res = await fetch(`${API_BASE_URL}/subscriptions/`, { headers: getHeaders() });
  return handleResponse(res);
}

export async function createSubscription(data: Omit<Subscription, "id">): Promise<Subscription> {
  const res = await fetch(`${API_BASE_URL}/subscriptions/`, {
    method: "POST",
    headers: getHeaders(),
    body: JSON.stringify(data),
  });
  return handleResponse(res);
}

export async function deleteSubscription(id: number): Promise<void> {
  const res = await fetch(`${API_BASE_URL}/subscriptions/${id}`, {
    method: "DELETE",
    headers: getHeaders(),
  });
  return handleResponse(res);
}
