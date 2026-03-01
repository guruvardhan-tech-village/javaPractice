package BankingSystem;

import java.util.Scanner;

public class CustomersUse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BankDAO1 bankm = new BankDAO1();
		
		System.out.println("WElCOME To Banking Services How Can We Help you Today!");
		System.out.println("1.create new customer account:");
		System.out.println("2.Debit amount");
		System.out.println("3.Credit Amount");
		System.out.println("4.View Account");
		System.out.println("5.Exit");
		
		int ch = sc.nextInt();
		sc.nextLine();
		
		while(true) {
			switch (ch) {
			case 1:
				System.out.println("Enter your name:");
				String name = sc.nextLine();
				System.out.println("Enter your Email address:(example@gmail.com)");
				String mail =sc.nextLine();
				System.out.println("Enter the Password:");
				String pass = sc.nextLine();
				
				bankm.createCustomer(name, mail, pass);
				break;
				
			case 2:
				System.out.println("Enter accountID:");
				int accno = sc.nextInt();
				System.out.println("Enter amount to withdraw");
				double amount = sc.nextDouble();
				
				bankm.debitAmount(accno, amount);
				break;
			
			case 3:
				System.out.println("Enter Account Number:");
				int accNo = sc.nextInt();
				System.out.println("Enter the amount to credit");
				double amt= sc.nextDouble();
				
				bankm.creditAmount(accNo, amt);
				break;
				
			case 4:
				System.out.println("Enter the Account Number to View Details:");
				int accn=sc.nextInt();
				
				bankm.viewAccount(accn);
				break;
			case 5:
				System.out.println("Thank you for using banking services Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid entry Try again!");
				break;
			}
			sc.close();
		}
		

	}

}
