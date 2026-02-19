package com;

public class DivisionException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=10;
		try {
			int c=b/a;
			System.out.println(c);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Hello");
	}

}
