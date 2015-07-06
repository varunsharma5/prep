package com.interview.algorithms.sorting;

public class BubbleSort extends AbstractSort {

	/**
	 * Requries N(N-1)/2 = Nsqr/2 = O(Nsqr)
	 */
	public void sort(int[] unsorted) {

		int length = unsorted.length;
		// start the out from the end
		for (int out = length - 1; out > 0; out--) {
			// in would loop till out and will reduce after each cycle as the
			// the outer elemnts are already sorted
			for (int in = 0; in < out; in++) {
				if (unsorted[in] > unsorted[in + 1]) {
					swap(unsorted, in, in + 1);
				}

				display(unsorted);

			}
		}

	}

	
	/*
	 * Output
	 * Contents:1 ---> 9, 10, 8, 7,        Contents:2 ---> 9, 8, 10, 7,
	 * Contents:3 ---> 9, 8, 7, 10,        Contents:4 ---> 8, 9, 7, 10,
	 * Contents:5 ---> 8, 7, 9, 10,        Contents:6 ---> 7, 8, 9, 10,
	 */
	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8, 7, 4 };
		BubbleSort bubblesort = new BubbleSort();
		bubblesort.sort(unsorted);

	}

}
