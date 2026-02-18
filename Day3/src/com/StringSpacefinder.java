package com;

import java.util.Scanner;

public class StringSpacefinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter one sentence:");
		String input = sc.nextLine();
		
		int result=0;
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch==' ') {
				result ++;
			}
		}
		
		System.out.println("Space count is: "+result);
		sc.close();
	}

}
