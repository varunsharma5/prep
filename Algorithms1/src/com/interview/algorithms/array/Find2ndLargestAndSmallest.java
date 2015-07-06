package com.interview.algorithms.array;

/**
 * Write an efficient program to find secong largest and second smallest element
 * in an array.
 * 
 * http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-
 * an-array/
 * 
 * @author ajitkoti
 * 
 */
public class Find2ndLargestAndSmallest {
	private static int INT_MAX = Integer.MAX_VALUE;
	private static int INT_MIN = -1;

	private static void print2Smallest(int arr[], int arr_size) {
		int i, first, second;

		/* There should be atleast two elements */
		if (arr_size < 2) {
			System.out.println(" Invalid Input ");
			return;
		}

		first = second = INT_MAX;
		for (i = 0; i < arr_size; i++) {
			/*
			 * If current element is smaller than first then update both first
			 * and second
			 */
			if (arr[i] < first) {
				second = first;
				first = arr[i];
			}

			/* If arr[i] is in between first and second then update second */
			else if (arr[i] < second && arr[i] != first)
				second = arr[i];
		}
		if (second == INT_MAX)
			System.out.println("There is no second smallest element");
		else
			System.out
					.println("The smallest element is and second Smallest element is "
							+ first + "--" + second);
	}
	
	private static void print2Largest(int arr[], int arr_size) {
		int i, first, second;

		/* There should be atleast two elements */
		if (arr_size < 2) {
			System.out.println(" Invalid Input ");
			return;
		}

		first = second = INT_MIN;
		for (i = 0; i < arr_size; i++) {
			/*
			 * If current element is smaller than first then update both first
			 * and second
			 */
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			}

			/* If arr[i] is in between first and second then update second */
			else if (arr[i] > second && arr[i] != first)
				second = arr[i];
		}
		if (second == INT_MIN)
			System.out.println("There is no second largest element");
		else
			System.out
					.println("The largest element is and second largest element is "
							+ first + "--" + second);
	}

	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		int n = arr.length;
		print2Smallest(arr, n);
		print2Largest(arr, n);
	}

}
