package com;

import java.util.Scanner;

public class VowelsCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text:");
		String input = sc.nextLine();
		
		String text = input.toLowerCase();
		
		int count =0;
		
		for(int i=0;i<text.length();i++) {
			char ch = text.charAt(i);
			if(ch =='a' || ch =='e' || ch=='i' || ch=='o' || ch=='u') {
				count++;
			}
		}
		
		System.out.println("Number of Vowels in the text \""+input + "\"is "+count);
		sc.close();
	}

}
