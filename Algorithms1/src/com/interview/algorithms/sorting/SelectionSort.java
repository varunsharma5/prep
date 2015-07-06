package com.interview.algorithms.sorting;

public class SelectionSort extends AbstractSort {

	/**
	 * Requries N(N-1)/2 = Nsqr/2 = 0(Nsqr) but faster than bubble sorts as less
	 * swaps are required.
	 */
	public void sort(int[] unsorted) {
		int min;
		int length = unsorted.length;

		for (int out = 0; out <= length; out++) {
			min = out; // select the out as min
			// in starts with next to out(i.e.min) so that it can be compared
			// with min (i.e out +1)
			for (int in = out + 1; in < length; in++) {
				if (unsorted[in] < unsorted[min]) {
					min = in;
				}
				swap(unsorted, out, min);

				display(unsorted);

			}
		}

	}

	/**
	 * Contents:1 ---> 9, 10, 8, 7, 6, Contents:2 ---> 8, 10, 9, 7, 6,
	 * Contents:3 ---> 7, 10, 9, 8, 6, Contents:4 ---> 6, 10, 9, 8, 7,
	 * Contents:5 ---> 6, 9, 10, 8, 7, Contents:6 ---> 6, 8, 10, 9, 7,
	 * Contents:7 ---> 6, 7, 10, 9, 8, Contents:8 ---> 6, 7, 9, 10, 8,
	 * Contents:9 ---> 6, 7, 8, 10, 9, Contents:10 ---> 6, 7, 8, 9, 10,
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8, 7, 6 };
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(unsorted);

	}

}
