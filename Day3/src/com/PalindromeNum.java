package com;

import java.util.Scanner;

class PalindromeMethods{
	public void mathPalindrome(int num) {
		int reversed = 0;
		int original = num;
		
		while(num>0) {
			int digit = num %10;
			reversed = reversed * 10 +digit;
			num = num/10;
		}
		
		System.out.println("By Math Palindrome Method");
		
		if(reversed == original) {
			System.out.println("palindrome");
		}else {
			System.out.println("not palindrome");
		}
	}
	
	public void stringPalindrome(int num) {
		String str =String.valueOf(num);
		String reversed = new StringBuilder(str).reverse().toString();
		
		System.out.println("By String palindrome method");
		
		if(str.equals(reversed)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
		
	}
}

public class PalindromeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter more than 2 digit number to check palindrome:");
		int num = sc.nextInt();
		
		PalindromeMethods obj1 = new PalindromeMethods();
		obj1.mathPalindrome(num);
		obj1.stringPalindrome(num);
		

	}

}
