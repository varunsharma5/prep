package com.interview.algorithms;

import java.util.Arrays;

public class MinDiffNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 6, 17, 15, 12, 14, 28, 21, 25 };
		int min;
		int minIdex=0;
		Arrays.sort(arr);
		
		min = arr[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] < min) {
				min = arr[i + 1] - arr[i];
				minIdex=i;
			}
		}
		int smallerNumber = arr[minIdex];
		int largerNumber = arr[minIdex+ 1];
		System.out.println("The minimum difference is: " + largerNumber + "-"+ smallerNumber + "=" + min);

	}

}
