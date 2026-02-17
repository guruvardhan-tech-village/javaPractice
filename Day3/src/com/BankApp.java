package com;

import java.util.*;

class BankAccount{
	String name;
	double balance;
	
	public BankAccount(String name,double initialBalance){
		this.name = name;
		this.balance = initialBalance;
		System.out.println("Account created for "+name+"with initial balance "+balance);
	}
	public void showBalance() {
		System.out.println("Initial Balance is:Rs. "+balance);
	}
}

class Transactions extends BankAccount{
	
	public Transactions(String name,double initialBalance) {
		super(name,initialBalance);
	}
	
	public void credit(double amount,String method) {
		balance += amount;
		System.out.println("The amount " +amount+ " credited via "+method);
		System.out.println("Total balance is: "+balance);
	}
	public void debit(double amount,String method) {
		if(balance>=amount){
			balance -= amount;
			System.out.println("The amount " +amount+ " debited via "+method);
			System.out.println("Total balance is: "+balance);
		}else {
			System.out.println("Sorry! You dont have that balance.");
		}
		
	} 
}

public class BankApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Transactions obj1= new Transactions("Guru",25000);
		
		int umethod;
		double amount;
		String method;
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Bank application services:");
			System.out.println("1.Credit");
			System.out.println("2.Debit");
			System.out.println("3.Check balance");
			System.out.println("4.Exit");
			System.out.println("Choose an option (1,2,3,4):");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter amount:");
				amount = sc.nextDouble();
				System.out.println("Enter which method 1.Net Banking, 2.ATM , 3.Cheque");
				umethod = sc.nextInt();
				
				if(umethod ==1) {
					method= "Net Banking";
				}
				else if(umethod == 2) {
					method = "ATM";
				}else if(umethod == 3) {
					method = "Cheque";
				}else {
					System.out.println("Invalid try again!");
					break;
				}
				obj1.credit(amount, method);
				break;
				
			case 2:
				System.out.println("Enter amount:");
				amount = sc.nextDouble();
				System.out.println("Enter which method 1.Net Banking, 2.ATM , 3.Cheque");
				umethod = sc.nextInt();
				if(umethod ==1) {
					method= "Net Banking";
				}
				else if(umethod == 2) {
					method = "ATM";
				}else if(umethod == 3) {
					method = "Cheque";
				}else {
					System.out.println("Invalid try again!");
					break;
				}
				obj1.debit(amount, method);
				break;				
			case 3:
				obj1.showBalance();
				break;
			case 4:
				exit=true;
				System.out.println("Exiting.... Thank you for using Banking services!");
				break;
			default:
				System.out.println("Invalid Option.");
			}
		}
		sc.close();
		
	}

}
