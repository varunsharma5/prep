package com.interview.algorithms.array;

import java.util.Arrays;

/**
 * 
 * @author ajitkoti
 *
 */
public class ReverseAnArray {

	private static void reverseArray(int arr[], int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(arr));
		reverseArray(arr, 0, 5);
		System.out.println("Reversed array is");
		System.out.println(Arrays.toString(arr));
	}

}
