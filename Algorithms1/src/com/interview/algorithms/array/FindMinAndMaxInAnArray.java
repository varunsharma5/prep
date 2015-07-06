package com.interview.algorithms.array;

/**
 * If n is odd then initialize min and max as first element. If n is even then
 * initialize min and max as minimum and maximum of the first two elements
 * respectively. For rest of the elements, pick them in pairs and compare their
 * maximum and minimum with max and min respectively.
 * 
 * http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * 
 * @author ajitkoti
 * 
 */
public class FindMinAndMaxInAnArray {
	static void getMinMax(int arr[], int n) {
		int i;
		int max, min = 0;

		/*
		 * If array has even number of elements then initialize the first two
		 * elements as minimum and maximum
		 */
		if (n % 2 == 0) {
			if (arr[0] > arr[1]) {
				max = arr[0];
				min = arr[1];
			} else {
				min = arr[0];
				max = arr[1];
			}
			i = 2; /* set the startung index for loop */
		}else { //If array has odd number of elements then initialize the first element as minimum and maximum
			min = arr[0];
			max = arr[0];
			i = 1; /* set the startung index for loop */
		}

		/*
		 * In the while loop, pick elements in pair and compare the pair with
		 * max and min so far
		 */
		while (i < n - 1) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > max)
					max = arr[i];
				if (arr[i + 1] < min)
					min = arr[i + 1];
			} else {
				if (arr[i + 1] > max)
					max = arr[i + 1];
				if (arr[i] < min)
					min = arr[i];
			}
			i += 2; /*
					 * Increment the index by 2 as two elements are processed in
					 * loop
					 */
		}

		System.out.println("Max is " + max + " and Min is " + min);
	}

	public static void main(String[] args) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		int arr_size = 6;
		getMinMax(arr, arr_size);

	}

}
