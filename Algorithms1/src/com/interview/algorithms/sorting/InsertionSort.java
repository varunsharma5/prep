package com.interview.algorithms.sorting;

public class InsertionSort extends AbstractSort {

	/**
	 * Requries N(N-1)/2 = Nsqr/2 = 0(Nsqr) but faster than bubble sorts as less
	 * swaps are required.
	 */
	public void sort(int[] unsorted) {
		int temp;
		int in;
		int length = unsorted.length;

		// start the outer loop at 1 so would be compared with previous 0
		for (int out = 1; out < length; out++) {
			temp = unsorted[out]; // copy into temp , later insert at the
									// correct empty position
			in = out;
			while (in > 0 && unsorted[in - 1] >= temp) {
				// shift the elements if they are greater than temp
				unsorted[in] = unsorted[in - 1];
				--in;
			}
			// insert at the correct empty position after all shifts done
			unsorted[in] = temp;

			display(unsorted);

		}

	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(unsorted);

	}
}
