package com;

import java.util.Scanner;

interface Arth{
	public void getData(int a,int b);
}

interface Addition2 extends Arth {
	void add();
}
interface Substraction2 extends Arth{
	void sub();
}
interface Multi extends Arth{
	void multip();
	
}
interface Divis  extends Arth{
	void divs();
}

public class HybridInheritance2 implements Addition2,Substraction2,Multi,Divis{
	
	private int a;
	private int b;
	


	@Override
	public void getData(int a, int b) {
		// TODO Auto-generated method stub
		this.a=a;
		this.b=b;
	}

	@Override
	public void divs() {
		// TODO Auto-generated method stub
		try {
			int d=  a/b;
			System.out.printf("Division: %d",d);
		}catch(ArithmeticException e){
			System.out.println("Zero Division Erorr");
			e.printStackTrace();
			System.out.println("Operation completed");
		}
		
	}

	@Override
	public void multip() {
		// TODO Auto-generated method stub
		System.out.println("Multiplication: "+(a*b));
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		System.out.println("Substraction:"+ (a-b));
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("Addition: "+(a+b));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of a and b");
		int a= sc.nextInt();
		int b = sc.nextInt();
		
		HybridInheritance2 hy = new HybridInheritance2();
		
		hy.getData(a, b);
		
		System.out.println("Enter 1.addition 2.Substration 3.Multiplication 4.Division 5. Exit");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			hy.add();
			break;
		case 2:
			hy.sub();
			break;
		case 3:
			hy.multip();
			break;
		case 4:
			hy.divs();
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
