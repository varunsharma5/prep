package com.interview.algorithms.array;

/**
 * Write a program to print all the LEADERS in the array. An element is leader
 * if it is greater than all the elements to its right side. And the rightmost
 * element is always a leader. For example int the array {16, 17, 4, 3, 5, 2},
 * leaders are 17, 5 and 2.
 * 
 * Let the input array be arr[] and size of the array be size.
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 * 
 * @author ajitkoti
 *
 */
public class FindLeadersInAnArray {

	/* Function to print leaders in an array */
	private static void printLeaders(int arr[], int size) {
		int max_from_right = arr[size - 1];
		int i;

		/* Rightmost element is always leader */
		System.out.println(max_from_right +", ");

		for (i = size - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				System.out.println(arr[i]);
				max_from_right = arr[i];
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		printLeaders(arr, 6);

	}

}
