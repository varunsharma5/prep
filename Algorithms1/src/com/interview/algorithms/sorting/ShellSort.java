package com.interview.algorithms.sorting;

public class ShellSort extends AbstractSort {

	@Override
	public void sort(int[] unsorted) {
		int inner, outer;

		int h = 1;
		int length = unsorted.length;

		while (h <= length / 3)
			h = h * 3 + 1; // get h value i.e 0, 4, 8

		while (h > 0) {

			for (outer = h; outer < length; outer++) {
				int temp = unsorted[outer];
				inner = outer;

				while (inner > h - 1 && unsorted[inner - h] >= temp) {
					unsorted[inner] = unsorted[inner - h];
					inner = inner - h;
				}
				unsorted[inner] = temp;
			}
			h = (h - 1) / 3;

		}
		
		display(unsorted);

	}

	public static void main(String[] args) {
		int[] unsorted = new int[] { 10, 9, 8, 7 };
		ShellSort sort = new ShellSort();
		sort.sort(unsorted);
	}

}
