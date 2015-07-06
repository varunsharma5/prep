package com.interview.algorithms.array;

/**
 * Given an array of positive integers. All numbers occur even number of times
 * except one number which occurs odd number of times. Find the number in O(n)
 * time & constant space.
 * 
 * Example: I/P = [1, 2, 3, 2, 3, 1, 3] O/P = 3
 * 
 * Do bitwise XOR of all the elements. Finally we get the number which has odd
 * occurrences.
 * 
 * 
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * 
 * @author ajitkoti
 * 
 */
public class FindTheNumberOccurringOddNumberOfTimes {

	private static int getOddOccurrence(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++){
			res = res ^ ar[i];
			System.out.println(res +" --"+ar[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int ar[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int n = ar.length;
		System.out.println(getOddOccurrence(ar, n));
	}

}
