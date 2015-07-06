package com.interview.algorithms.array;

/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 *
 *
 */
public class FindLargestSumContiguousSubarray {

	private static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0], i;
		int curr_max = a[0];

		for (i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	/* Driver program to test maxSubArraySum */
	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = a.length;
		int max_sum = maxSubArraySum(a, n);
		System.out.println("Maximum contiguous sum is " + max_sum);

	}

}
