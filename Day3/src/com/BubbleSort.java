package com;

import java.util.Scanner;

class Sorting{
	public static void sortArray(int[] numList,int n) {
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(numList[j]>numList[j+1]) {
					int temp = numList[j];
					numList[j]= numList[j+1];
					numList[j+1]=temp;
				}
			}
		}
		System.out.print("Sorted Array:");
//		for(int list : numList) {
//			System.out.print(list+" ");
//		}
		for(int i=0;i<n;i++) {
			System.out.print(numList[i]+" ");
		}
		
	}
	
	public void largestNum(int[] numList,int n) {
		int largest = 0;
		System.out.println();
		System.out.print("List of array elements: ");
		for(int i =0;i<n;i++) {
			System.out.print(numList[i]+" ");
			if(numList[i]>largest) {
				largest=numList[i];
			}
		}
		System.out.println();
		System.out.println("Largest element is: "+largest);
		
	}
}

public class BubbleSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array(n):");
		int n= sc.nextInt();
		int[] numList = new int[n];
		
		System.out.printf("Enter %d elements(Integer):%n",n);
		for(int i=0;i<n;i++) {
			numList[i]=sc.nextInt();
		}
		
		sc.close();
		//int[] numList = {56,42,34,76,86,52,98,22};
		
//		System.out.print("Unsorted array: ");
//		for(int i =0;i<n;i++) {
//			System.out.print(numList[i]+" ");
//		}
		System.out.println();
		
		Sorting.sortArray(numList,n);
		
		Sorting obj1= new Sorting();
		obj1.largestNum(numList,n);
		
		
		//
	}

}
