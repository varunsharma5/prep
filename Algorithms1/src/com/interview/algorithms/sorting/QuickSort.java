package com.interview.algorithms.sorting;

public class QuickSort extends AbstractSort {
	private int[] unsorted;

	/**
	 * Requries N(N-1)/2 = Nsqr/2 = O(Nsqr) but faster than bubble sorts as less
	 * swaps are required.
	 */
	public void sort(int[] unsorted) {
		this.unsorted = unsorted;
		reQuickSort(0, unsorted.length - 1);
		display(unsorted);
	}

	public void reQuickSort(int left, int right) {
		 display(unsorted);

		if (right - left <= 0) // already sorted
			return;
		else {
			int pivot = unsorted[right];
			int partition = partition(left, right, pivot);
			reQuickSort(left, partition - 1);
			reQuickSort(partition + 1, right);
		}

	}

	private int partition(int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {
			while (unsorted[++leftPtr] < pivot)
				; // find greater than pivot

			while (rightPtr > 0 && unsorted[--rightPtr] > pivot)
				; // find smaller item

			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(unsorted, leftPtr, rightPtr);
			}
		}
		swap(unsorted, leftPtr, right);
		return leftPtr;
	}

	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8,7};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(unsorted);

	}

}
