package com.interview.algorithms.array;

public class MaxDiffBtwTwoElementsLargerElementAppearsAftSmallerNo {

	public static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > max_diff)
					max_diff = arr[j] - arr[i];
			}
		}
		return max_diff;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 90, 10, 110 };
		System.out.println("Maximum difference is " + maxDiff(arr, 5));

	}

}
