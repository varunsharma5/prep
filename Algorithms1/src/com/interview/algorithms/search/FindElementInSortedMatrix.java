package com.interview.algorithms.search;

/**
 * Given a matrix in which each row and each column is sorted, write a method to
 * find an element in it.
 * 
 * @author ajitkoti
 *
 */
public class FindElementInSortedMatrix {

	/**
	 * Assumptions: » Rows are sorted left to right in ascending order. Columns
	 * are sorted top to bottom in ascending order.
	 * 
	 * This algorithm works by elimination. Every move to the left(--col)
	 * eliminates all the elements below the current cell in that column.
	 * Likewise, every move down eliminates all the elements to the left of the
	 * cell in that row.
	 * 
	 * @param mat
	 * @param elem
	 * @param M
	 * @param N
	 * @return
	 */
	private static boolean FindElem(int[][] mat, int elem, int M, int N) {
		int row = 0;
		int col = N - 1;

		while (row < M && col >= 0) {
			if (mat[row][col] == elem) {
				return true;
			} else if (mat[row][col] > elem) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

}
