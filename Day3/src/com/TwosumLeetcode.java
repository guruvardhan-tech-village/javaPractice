package com;

class Twosum{
	public static int[] twoSumArraylogic(int[] nums,int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {-1,-1};
	}
}

public class TwosumLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,6,2,3,4};
		int target=5;
		int[] sum = Twosum.twoSumArraylogic(arr, target);
		
		System.out.printf("Indices of two numbers for target %d %n",target);
		for(int i=0;i<sum.length;i++) {
			System.out.print(sum[i]+" ");
		}
	}

}
