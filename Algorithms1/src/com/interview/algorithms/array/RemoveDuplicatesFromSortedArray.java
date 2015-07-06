package com.interview.algorithms.array;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

	public static void removeDuplicates() {
		int[] a = new int[] { 3, 2, 4,8, 3, 8, 4, 5, 5 };

		HashSet<Integer> keys = new HashSet<Integer>();
		int[] result = new int[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (keys.add(a[i])) {
				result[j] = a[i];
				j++;
			}
		}
		Arrays.copyOf(result, j);

		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + ",");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		removeDuplicates();
	}

}
