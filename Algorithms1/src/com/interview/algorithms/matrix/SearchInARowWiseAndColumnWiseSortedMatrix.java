package com.interview.algorithms.matrix;

/**
 * Given an n x n matrix, where every row and column is sorted in increasing
 * order. Given a number x, how to decide whether this x is in the matrix. The
 * designed algorithm should have linear time complexity.
 * 
 * 
 * 
 * Algorithm 1) Start with top right element
 * 
 * 2) Loop: compare this element e with x ….i) if they are equal then return its
 * position …ii) e < x then move it to down (if out of bound of matrix then
 * break return false) ..iii) e > x then move it to left (if out of bound of
 * matrix then break return false)
 * 
 * 3) repeat the i), ii) and iii) till you find element or returned false
 * 
 * 
 * http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix
 * /
 * 
 * @author ajitkoti
 * 
 */
public class SearchInARowWiseAndColumnWiseSortedMatrix {

	/**
	 * 
	 * @param mat
	 * @param size
	 * @param x
	 * @return
	 */
	private static int search(int mat[][], int size, int x) {
		int i = 0, j = size - 1; // set indexes for top right element
		
		while (i < size && j >= 0) {
			if (mat[i][j] == x) {
				System.out.println("Found at-> " + i + "--" + j);
				return 1;
			}
			if (mat[i][j] > x)
				j--;
			else
				// if mat[i][j] < x
				i++;
		}

		System.out.println("Element not found");
		return 0; // if ( i==n || j== -1 )

	}

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		search(mat, mat.length, 29);
	}

}
