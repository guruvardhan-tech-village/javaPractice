package com;

import java.util.Scanner;

public class PrimenumFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int in = sc.nextInt();
		
		if(in<=1) {
			System.out.println("Enter value more than one");
		}else {
			for(int i=2;i<=in;i++) {
				boolean PrimeNum=true;
				
				for(int j=2;j<=Math.sqrt(i);j++) {
					if(i%j==0) {
						PrimeNum=false;
						break;
					}
					
				}
				
				if(PrimeNum) {
					System.out.print(i+" ");
				}
				
			}
			
		}		
		sc.close();
	}

}
