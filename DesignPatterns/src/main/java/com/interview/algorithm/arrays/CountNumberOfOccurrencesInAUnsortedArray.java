package com.interview.algorithm.arrays;

import java.util.HashMap;

public class CountNumberOfOccurrencesInAUnsortedArray {
	
	public static void main(String[] args) {
		int a[] = new int[]{1, 1, 2, 2, 2, 2, 3};
		System.out.println(count(a, 3));
	}

	private static int count(int[] a, int num) {
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		
		for(int n : a) {
			Integer temp = countMap.get(n);
			if(temp == null) {
				countMap.put(n, 1);
			} else {
				int count = countMap.get(n);
				count++;
				countMap.put(n, count);
			}
		}
		
		return countMap.get(num);
			
	}
}
