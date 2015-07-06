package com.interview.algorithms.array;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the
 * occurrences of x in arr[]. Expected time complexity is O(Logn)
 * 
 * Ex Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 2 Output: 4 // x (or 2) occurs
 * 4 times in arr[]
 * 
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 3 Output: 1
 * 
 * 
 * @author ajitkoti
 *
 */
public class CountNumberOfOccurrencesInASortedArray {

	/*
	 * if x is present in arr[] then returns the count of occurrences of x,
	 * otherwise returns -1.
	 */
	public static int count(int arr[], int x) {
		int i; // index of first occurrence of x in arr[0..n-1]
		int j; // index of last occurrence of x in arr[0..n-1]

		/* get the index of first occurrence of x */
		i = first(arr, 0, arr.length-1, x);

		/* If x doesn't exist in arr[] then return -1 */
		if (i == -1)
			return i;

		/*
		 * Else get the index of last occurrence of x. Note that we are only
		 * looking in the subarray after first occurrence
		 */
		j = last(arr, i, arr.length-1, x);

		/* return count */
		return j - i + 1;
	}

	/*
	 * if x is present in arr[] then returns the index of FIRST occurrence of x
	 * in arr[0..n-1], otherwise returns -1
	 */
	private static int first(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x);
			else
				return first(arr, low, (mid - 1), x);
		}
		return -1;
	}

	/*
	 * if x is present in arr[] then returns the index of LAST occurrence of x
	 * in arr[0..n-1], otherwise returns -1
	 */
	private static int last(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */
			if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x);
			else
				return last(arr, (mid + 1), high, x);
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 3, 3, 3 };
		int x = 3; // Element to be counted in arr[]		
		int count = count(arr, x);
		System.out.println("No Of Occurence of "+ x + " is " + count);
	}

}
