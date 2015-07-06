package com.interview.algorithms.array;

import java.util.Arrays;

/**
 * Replace element of an Array with nearest bigger number at right side of the
 * Array in O(n) For example if the input Array is 7, 5, 6, 3, 4, 1, 2, 9, 11
 * output array should be 9, 6, 9, 4, 9, 2, 9, 11, 11
 * 
 * http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 * 
 * @author ajitkoti
 * 
 */
public class ReplaceElementWithGreatestOnRight {

	/**
	 * 
	 * @param arr
	 * @param size
	 */
	public static void nextGreatest(int arr[], int size) {
		// Initialize the next greatest element
		int max_from_right = arr[size - 1];

		// Replace all other elements with the next greatest
		for (int i = size - 2; i >= 0; i--) {
			// Store the current element (needed later for updating
			// the next greatest element)
			int temp = arr[i];

			// Replace current element with the next greatest
			arr[i] = max_from_right;

			// Update the greatest element, if needed
			if (max_from_right < temp)
				max_from_right = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		nextGreatest(arr, arr.length);
		System.out.println("The modified array is:");
		System.out.println(Arrays.toString(arr));

	}

}
