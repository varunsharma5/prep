package com.interview.algorithms.array;

import java.util.Arrays;

/**
 * Find duplicates in O(n) time and O(1) extra space
 * 
 * 
 * 
 * Given an array of n elements which contains elements from 0 to n-1, with any
 * of these numbers appearing any number of times. Find these repeating numbers
 * in O(n) and using only constant memory space.
 * 
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should
 * be 1, 3 and 6.
 * 
 * 
 * Algorithm: traverse the list for i= 0 to n-1 elements { check for sign of
 * A[abs(A[i])] ; if positive then make it negative by
 * A[abs(A[i])]=-A[abs(A[i])]; else // i.e., A[abs(A[i])] is negative this
 * element (ith element of list) is a repetition }
 * 
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-
 * space/
 * 
 * @author ajitkoti
 * 
 */
public class RemoveDuplicatesInOnTimeAndConstantExtraSpace {

	private static void printRepeating(int arr[], int size) {
		int i;
		;
		for (i = 0; i < size; i++) {
			System.out.println("i is "+ i +" a[i] is " +arr[i]);
			System.out.println("Math.abs(arr[i]) is "+ Math.abs(arr[i]) +" arr[Math.abs(arr[i])] is " +arr[Math.abs(arr[i])]);
			if (arr[Math.abs(arr[i])] >= 0){
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			System.out.println(Arrays.toString(arr));
			}
			else{
				System.out.println("The repeating element is : "+Math.abs(arr[i])+",");
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		System.out.println(Arrays.toString(arr));
		printRepeating(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

}
