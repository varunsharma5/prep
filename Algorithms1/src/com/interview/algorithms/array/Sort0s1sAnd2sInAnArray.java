package com.interview.algorithms.array;

import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * 
 * Example Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
 * Output = {0, 0, 0, 0, * 0, 1, 1, 1, 1, 1, 2, 2}
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * @author ajitkoti
 * 
 */
public class Sort0s1sAnd2sInAnArray {

	private static void sort0s1s2s(int a[], int arr_size) {
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0;

		while (mid <= hi) {
			switch (a[mid]) {
			case 0:
				swap(a, lo++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(a, mid, hi--);
				break;
			}
		}
	}

	private static void swap(int[] unsorted, int i, int j) {
		int temp = unsorted[i];
		unsorted[i] = unsorted[j];
		unsorted[j] = temp;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 0, 1, 2, 1, 1, 0, 1, 2, 0, 2, 1, 0, 2 };
		sort0s1s2s(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}
}
