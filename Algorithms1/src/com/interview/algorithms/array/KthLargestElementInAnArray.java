package com.interview.algorithms.array;

/**
 * k largest(or smallest) elements in an array Use order statistic algorithm to
 * find the kth largest element.
 * 
 * Use QuickSort Partition algorithm to partition around the kth largest number
 * O(n). 3) Sort the k-1 elements (elements greater than the kth largest
 * element) O(kLogk). This step is needed only if sorted output is required.
 * 
 * Time complexity: O(n) if we don’t need the sorted output, otherwise
 * O(n+kLogk)
 * http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
 * 
 * @author ajitkoti
 * 
 */
public class KthLargestElementInAnArray {

	public static int kthSmallest(int[] array, int k) {
		return orderStatistic(array, k, 0, array.length - 1);
	}

	public static int kthLargest(int[] array, int k) {
		return orderStatistic(array, array.length - k + 1, 0, array.length - 1);
	}

	private static int orderStatistic(int[] array, int k, int first, int last) {

		int pivotPosition = partition(array, first, last);
		if (pivotPosition == k - 1) {
			return array[k - 1];
		}
		if (k - 1 < pivotPosition) {
			return orderStatistic(array, k, first, pivotPosition - 1);
		} else {
			return orderStatistic(array, k, pivotPosition + 1, last);
		}
	}

	public static int partition(int[] array, int first, int last) {
		int pivot = array[first];
		int pivotPosition = first++;
		while (first <= last) {
			// scan for values less than the pivot
			while ((first <= last) && (array[first] < pivot)) {
				first++;
			}

			// scan for values greater than the pivot
			while ((last >= first) && (array[last] >= pivot)) {
				last--;
			}

			if (first > last) {
				// swap the last uncoformed
				// element with the pivot
				swap(array, pivotPosition, last);
			} else {
				// swap unconformed elements:
				// first that was not lesser than the pivot
				// and last that was not larger than the pivot
				swap(array, first, last);
			}
		}
		return last;
	}

	private static void swap(int[] array, int pivotPosition, int last) {
		int temp = array[pivotPosition];
		array[pivotPosition] = array[last];
		array[last] = temp;

	}

}
