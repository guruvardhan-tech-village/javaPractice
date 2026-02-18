package com;

import java.util.Scanner;

public class FibonacciSeries {

	static int fib(int n) {
	    if(n <= 1) return n;
	    return fib(n-1) + fib(n-2);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a=0,b=1;
		
		for(int i=1;i<=n;i++) {
			System.out.print(a+" ");
			int next = a+b;
			a=b;
			b=next;
		}

		System.out.println();
		
		int c=0,d=1;
		for(int i=2;i<=n;i++){
		    int next = c+d;
		    c=d;
		    d=next;
		}
		System.out.println(d);
		
		for(int i=0;i<n;i++) {
		    System.out.print(fib(i) + " ");
		}


		sc.close();
	}

}
