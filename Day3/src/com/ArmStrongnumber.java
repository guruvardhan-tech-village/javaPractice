package com;

import java.util.Scanner;

public class ArmStrongnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter multidigit number for ArmStrong number calculation!");
		int num = sc.nextInt();
		
		int temp = num;
		int digits = 0;
		int sum = 0;
		
		String s = Integer.toString(num);
		digits = s.length();
		
		temp = num;
		while(temp>0) {
			int lastDigit = temp%10;
			sum += Math.pow(lastDigit, digits);
			temp=temp/10;
		}
		
		if(sum==num) {
			System.out.println(num+" is a ArmStrong number");
		}else {
			System.out.println(num +" is Not an ArmStrong Number");
		}
		sc.close();
		
	}

}
