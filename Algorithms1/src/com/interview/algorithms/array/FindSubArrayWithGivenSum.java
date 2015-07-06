package com.interview.algorithms.array;

/**
 * 
 * @author ajitkoti
 * 
 */
public class FindSubArrayWithGivenSum {

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	private static int subArraySum(int arr[], int sum) {
		int n = arr.length;
		/*
		 * Initialize curr_sum as value of first element and starting point as 0
		 */
		int curr_sum = arr[0], start = 0, i;

		/*
		 * Add elements one by one to curr_sum and if the curr_sum exceeds the
		 * sum, then remove starting element
		 */
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				System.out.println("Sum found between indexes " + start + " - "
						+ (i - 1));
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];
		}

		// If we reach here, then no subarray
		System.out.println("No subarray found");
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 23;
		subArraySum(arr, sum);

	}

}
