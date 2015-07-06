package com.interview.algorithms.array;

/**
 * 
 * Given a 2D array, print it in spiral form.
 * 
 * Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * @author ajitkoti
 *
 */
public class PrintGivenMatrixInSpiralForm {

	private static void spiralPrint(int mrows, int ncols, int a[][]) {
		int i, rowIndex = 0, colIndex = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */

		while (rowIndex < mrows && colIndex < ncols) {
			
			/* Print the first row from the remaining rows */
			for (i = colIndex; i < ncols; ++i) {
				System.out.println(a[rowIndex][i] + ",");
			}
			rowIndex++;

			/* Print the last column from the remaining columns */
			for (i = rowIndex; i < mrows; ++i) {
				System.out.println(a[i][ncols - 1] + ",");
			}
			ncols--;

			/* Print the last row from the remaining rows */
			if (rowIndex < mrows) {
				for (i = ncols - 1; i >= colIndex; --i) {
					System.out.println(a[mrows - 1][i] + ",");
				}
				mrows--;
			}

			/* Print the first column from the remaining columns */
			if (colIndex < ncols) {
				for (i = mrows - 1; i >= rowIndex; --i) {
					System.out.println(a[i][colIndex] + ",");
				}
				colIndex++;
			}
		}
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 } };

		spiralPrint(a.length, a[0].length, a);
	}

}
