package com.interview.algorithms.array;

/**
 * Given an array of positive and negative integers, find the maximum sum possible from the different sub-arrays
 * http://www.careercup.com/question?id=12434667
 * @author ajitkoti
 * 
 */
public class MaximumSubArray {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int maxScan(int[] array) {
		if (array.length == 0)
			return -1;
		else if (array.length == 1)
			return array[0];
		else {
			int maxSum = array[0]; // take 0th element as max
			int current_max = array[0];
			for (int i = 1; i < array.length; i++) { // starts from 1
				current_max = Math.max(array[i], current_max + array[i]);
				maxSum = Math.max(maxSum, current_max);
			}
			return maxSum;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		System.out.println("Max is "+maxScan(arr));
		

	}

}
