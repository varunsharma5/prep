package com.interview.algorithms.array;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
 * elements.
 * 
 * Instead of moving one by one, divide the array in different sets where number
 * of sets is equal to GCD of n and d and move the elements within sets. If GCD
 * is 1 as is for the above example array (n = 7 and d =2), then elements will
 * be moved within one set only, we just start with temp = arr[0] and keep
 * moving arr[I+d] to arr[I] and finally store temp at the right place.
 * 
 * Here is an example for n =12 and d = 3. GCD is 3 and
 * 
 * 
 * http://www.geeksforgeeks.org/array-rotation/
 * 
 * @author ajitkoti
 * 
 */
public class ArrayRotation {

	private static void leftRotate(int arr[], int d, int n) {
		int i;
		for (i = 0; i < d; i++)
			leftRotatebyOne(arr, n);
	}

	private static void leftRotatebyOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];
		arr[i] = temp;
	}

	/* Function to left rotate arr[] of siz n by d */
	static void leftGcdRotate(int arr[], int jump, int size) {
		int i, j, k, temp;
		int gcd = gcd(jump, size);

		for (i = 0; i < gcd; i++) {
			/* move i-th values of blocks */
			temp = arr[i];
			j = i;

			while (true) {
				k = j + jump;
				if (k >= size)
					k = k - size;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp;
		}

	}

	/* Fuction to get gcd of a and b */
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftGcdRotate(arr, 2, 7);
		System.out.println(Arrays.toString(arr));

	}

}
