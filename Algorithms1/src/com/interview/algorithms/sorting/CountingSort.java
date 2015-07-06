package com.interview.algorithms.sorting;

/**
 * Counting sort is a sorting technique based on keys between a specific range.
 * It works by counting the number of objects having distinct key values (kind
 * of hashing). Then doing some arithmetic to calculate the position of each
 * object in the output sequence. http://www.geeksforgeeks.org/counting-sort/
 * 
 * For simplicity, consider the data in the range 0 to 9. 
 * Input data: 1, 4, 1, 2, 7, 5, 2 1) 
 * Take a count array to store the count of each unique object.
 * Index: 0 1 2 3 4 5 6 7 8 9 
 * Count: 0 2 2 0 1 1 0 1 0 0
 * 
 * 2) Modify the count array such that each element at each index stores the sum
 * of previous counts. 
 * Index: 0 1 2 3 4 5 6 7 8 9 
 * Count: 0 2 4 4 5 6 6 7 7 7
 * 
 * The modified count array indicates the position of each object in the output
 * sequence.
 * 
 * 3) Output each object from the input sequence followed by decreasing its
 * count by 1. Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
 * Put data 1 at index 2 in output. Decrease count by 1 to place next data 1 at
 * an index 1 smaller than this index.
 * 
 * @author ajitkoti
 *
 */
public class CountingSort {

	private static void countSort(char[] str) {
		// The output character array that will have sorted str
		char output[] = new char[str.length];

		// Create a count array to store count of individual characters and
		// initialize count array as 0
		int[] count = new int[str.length + 1];
		int i;

		// Store count of each character
		for (i = 0; i < str.length - 1; ++i)
			++count[str[i]];

		// Change count[i] so that count[i] now contains actual position of
		// this character in output array
		for (i = 1; i <= str.length + 1; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		for (i = 0; i < str.length - 1; ++i) {
			output[count[str[i]] - 1] = str[i];
			--count[str[i]];
		}

		// Copy the output array to str, so that str now
		// contains sorted characters
		for (i = 0; i < str.length - 1; ++i)
			str[i] = output[i];

		System.out.println("Sorted string is " + str.toString());
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";// "applepp";
		countSort(str.toCharArray());
		System.out.println("Sorted string is " + str);
	}

}
