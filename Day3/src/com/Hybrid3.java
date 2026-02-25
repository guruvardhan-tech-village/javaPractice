package com;

import java.util.Scanner;

interface Payable{
	double calculateSalary();
}

class Employee1{
	protected int id;
	protected String name;
	
	public Employee1(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public void displayBasicInfo() {
		System.out.println("ID: "+id+" | Name: "+name);
	}
}

class PartTimeEmployee extends Employee1 implements Payable{
	
	private double hourlyRate;
	private int hoursWorked;
	
	public PartTimeEmployee(int id, String name,double rate,int hours) {
		super(id, name);
		this.hourlyRate = rate;
		this.hoursWorked = hours;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return hourlyRate * hoursWorked;
	}
	
	
	
}

class  FullTimeEmployee extends Employee1 implements Payable {
	
	public FullTimeEmployee(int id,String name,double salary) {
		super(id, name);
		this.monthlySalary = salary;
		// TODO Auto-generated constructor stub
	}

	private double monthlySalary;

	

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		
		return monthlySalary + (monthlySalary * 0.10);
	}

}

public class Hybrid3{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		
		double salary = 56000;	
		
		Payable emp1 = new FullTimeEmployee(id,name,salary);
		Payable emp2 = new PartTimeEmployee(id, name, 20,80);
		
		System.out.println("Realtime Payroll Processing:");
		((Employee1)emp1).displayBasicInfo();
		System.out.println("Salary: Rs "+emp1.calculateSalary());
		((Employee1)emp2).displayBasicInfo();
		System.out.println("Salary: Rs "+emp2.calculateSalary());
		
		sc.close();

	}
}
