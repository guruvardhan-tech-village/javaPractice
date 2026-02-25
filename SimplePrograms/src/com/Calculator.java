package com;

import java.util.Scanner;

class Variable{
	int a;
	int b;	
	
	public Variable(int a,int b) {
		this.a=a;
		this.b=b;
	}
}

class Additional extends Variable{
	public Additional(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public void add() {
		System.out.println("Addition: "+(a+b));
	}
}

interface Sub{
	void sub();
}
interface Mult{
	void mult();
}

class Calculatorclass extends Additional implements Sub,Mult{

	public Calculatorclass(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mult() {
		// TODO Auto-generated method stub
		System.out.println("Multiplication: "+(a*b));
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		System.out.println("Substraction:"+ (a-b));
		
	}
	public void division() {
		try {
			int d=  a/b;
			System.out.printf("Division: %d",d);
		}catch(ArithmeticException e){
			System.out.println("Zero Division Erorr");
			e.printStackTrace();
			System.out.println("Operation completed");
		}
	}
	
}

public class Calculator {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter value of a and b");
		int a= sc.nextInt();
		int b = sc.nextInt();
		
		Calculatorclass cl = new Calculatorclass(a,b);
		
		System.out.println("Enter 1.addition 2.Substration 3.Multiplication 4.Division 5. Exit");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			cl.add();
			break;
		case 2:
			cl.sub();
			break;
		case 3:
			cl.mult();
			break;
		case 4:
			cl.division();
			break;
		case 5:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid entry");
			break;
		}
		
		sc.close();
		

	}

}
