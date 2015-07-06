package com.interview.algorithm.arrays;

public class FindNumberInSortedArray {
	public static void main(String[] args) {
		int a[] = new int[]{1,2,3,4,5,6,7,8};
		System.out.println(find(a,8,0,a.length));
	}
	
	
	private static boolean find(int a[], int num, int lower, int upper)  {
		int mid = (lower+upper)/2 ;
		boolean ret = false;
		
		if(mid >= a.length) {
			return false;
		}
		
		if(a[mid] == num) {
			return true;
		} 

		if(a[mid] < num) {
			ret = find(a, num, mid+1, upper);
		} else {
			ret = find(a, num, lower, mid-1);
		}
		return ret;
	}
}