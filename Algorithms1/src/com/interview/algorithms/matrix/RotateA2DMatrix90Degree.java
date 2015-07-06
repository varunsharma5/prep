package com.interview.algorithms.matrix;

import java.util.Arrays;

/**
 * Algorithm to rotate an 2DMatrix or an Image 90 degrees in place? (No extra
 * memory)
 * 
 * @author ajitkoti
 *
 */
public class RotateA2DMatrix90Degree {

	/*
	 * rotates a 2D array 90 degree in place, in only one pass , doing only
	 * required swaps
	 */
	public static void rotateArray90Degree(int[][] input) {
		int arraySize = input.length - 1;
		for (int i = 0; i <= arraySize / 2; i++) { // arraySize/2 Because we
													// need to shift 90
			for (int j = i; j < (arraySize - i); j++) {
				shift90(input, arraySize, i, j);
			}
		}
	}

	/*
	 * Completes one 90 degree rotation cycle for a given i,j
	 */
	private static void shift90(int[][] input, int arraySize, int i, int j) {		
		int cur_i = i;
		int cur_j = j;
		int next_i = -1;
		int next_j = -1;
		int curElement = input[cur_i][cur_j]; // store first element
		do {
			next_i = cur_j; // first Element
			next_j = arraySize - cur_i; // last Element

			int temp = input[next_i][next_j];
			input[next_i][next_j] = curElement; // copy first element in last
												// place
			curElement = temp;

			cur_i = next_i;
			cur_j = next_j;

		} while (!(next_i == i && next_j == j));

	}

	public static void main(String[] args) {

		int[][] input = { { 1, 2 }, { 3, 4 } };
		int[][] expected = { { 3, 1 }, { 4, 2 } };
		rotateArray90Degree(input);
		System.out.println(Arrays.deepEquals(expected, input));

	}

}
