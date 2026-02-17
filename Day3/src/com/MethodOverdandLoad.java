package com;

class X{
	public static void add(int a,int b) {
		System.out.println(a+b);
	}
}
class Y extends X {
	public void show(int a,int b) {
		super.add(a,b);
		
	}
}

public class MethodOverdandLoad {

	public static void main(String[] args) {
		System.out.println("");
		int a= 3;
		int b = 5;
		//int c = 6;
		
		Y obj2 = new Y();
		obj2.show(a,b);
		
		
		
		
	}
}
