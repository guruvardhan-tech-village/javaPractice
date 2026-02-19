package com;

public class ExceptionHandeling {
	
	public static void drive(int age) {
		if(age<18) {
			throw new ArithmeticException("Not eligible for Drive");
		}else {
			System.out.println("Eligible for Drive");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,3,4,9,1};
		int x=5;
		int y=0;
		
		
		try {
			ExceptionHandeling.drive(12);//ArithmeticException
			
			System.out.println(arr[6]); //ArrayOutOfBoundException
			
			int c=x/y; //ArithmeticException
			
			System.out.println(c);
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage());
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally Exception Handeled.");
		}
		
		
		
		
	}

}
