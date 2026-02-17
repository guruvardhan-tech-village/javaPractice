package com;

import java.util.Scanner;

public class StringRepeat {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter one word: ");
		String in = sc.nextLine();
		
		//String text = in.toLowerCase();
		
		char ch;
		String result= "";
		for(int i=0;i<in.length();i++) {
			ch = in.charAt(i);
			if(result.indexOf(ch)==-1) {
				result+=ch;
			}
		}
		
		System.out.println("After removing repeated letters: "+result);
		sc.close();
	}
}
