package com.interview.algorithms.sorting;

public class MergeSort extends AbstractSort {

	private int[] unsorted;

	@Override
	public void sort(int[] unsorted) {
		this.unsorted = unsorted;
		int length = unsorted.length;
		int[] workspace = new int[length];

		recMergesort(workspace, 0, length - 1);

	}

	private void recMergesort(int[] workspace, int lowerbound, int upperbound) {

		// base condition for recursion
		if (lowerbound == upperbound) { // if range = 1 , then no use of sorting.
			return;
		} else {
			int mid = (lowerbound + upperbound) / 2; // find mid point

			recMergesort(workspace, lowerbound, mid); // sort first half
			recMergesort(workspace, mid + 1, upperbound); // sort second half

			merge(workspace, lowerbound, mid + 1, upperbound); // merge them
		}
	}

	private void merge(int[] workspace, int lowerPtr, int highPtr,	int upperbound) {
		int j = 0; // workspace index
		int lowerbound = lowerPtr;
		int mid = highPtr - 1;
		int n = upperbound - lowerbound + 1; // no of items

		while (lowerPtr <= mid && highPtr <= upperbound) {
			if (unsorted[lowerPtr] < unsorted[highPtr])
				workspace[j++] = unsorted[lowerPtr++];
			else
				workspace[j++] = unsorted[highPtr++];
		}

		while (lowerPtr <= mid) {
			workspace[j++] = unsorted[lowerPtr++];

		}

		while (highPtr <= upperbound) {
			workspace[j++] = unsorted[highPtr++];
		}

		for (int i = 0; i < n; i++) {
			unsorted[lowerbound + i] = workspace[i];
		}
		System.out.println("workspace Contents are");
		display(workspace);

		System.out.println("unsorted Contents are");
		display(unsorted);

	}

	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8, 7 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(unsorted);
	}

}
