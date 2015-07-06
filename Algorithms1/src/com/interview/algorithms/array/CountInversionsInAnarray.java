package com.interview.algorithms.array;

/**
 * Inversion Count for an array indicates – how far (or close) the array is from
 * being sorted. If array is already sorted then inversion count is 0. If array
 * is sorted in reverse order that inversion count is the maximum. Formally
 * speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i <
 * j
 * 
 * Example: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4,
 * 3).
 * 
 * @author ajitkoti
 *
 */
public class CountInversionsInAnarray {

	private static int getInvCount(int arr[], int n) {
		int inv_count = 0;
		int i, j;

		for (i = 0; i < n - 1; i++)
			for (j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					inv_count++;

		return inv_count;
	}

	/* Driver progra to test above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 20, 6, 4, 5 };
		System.out.println(" Number of inversions are " + getInvCount(arr, 5));

	}

}
