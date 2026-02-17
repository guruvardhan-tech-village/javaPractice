package com;

class Z {
	private int a;
	private int b;
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public void setA(int a) {
		// TODO Auto-generated method stub
		this.a=a;
	}
	public void setB(int b) {
		// TODO Auto-generated method stub
		this.b=b;
	}

}

public class PrivateVariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Z obj1= new Z();
		obj1.setA(10);
		obj1.setB(22);
		
		System.out.println(obj1.getA());
		System.out.println(obj1.getB());
		int sum = obj1.getB()+obj1.getA();
		System.out.println("Sum: "+sum );
		
		
	}

}
