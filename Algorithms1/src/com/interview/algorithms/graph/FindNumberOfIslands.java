package com.interview.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberOfIslands {
	

	private int[][] islandArray = { { 1, 0, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0 },
			{ 1, 0, 1, 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1 } };

	/**
	 * a[x][y] == 1 then its not visited 
	 * @param a
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isSafe( int x, int y) {
		return ((x >= 0) && (x < islandArray.length) && // row number is in range
				(y >= 0) && (y < islandArray[0].length) && // column number is in range
				islandArray[x][y] == 1); // value is 1 and not yet visited
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void isConnectedPresent(int x, int y) {
		if (x < 0 || y < 0 || y >= islandArray[0].length || x >= islandArray.length) {
			return;
		}
		// to move x and y around neighbors 
		int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// push the neighbors coordinates  whose values are 1
		Queue<Integer> Xstack = new LinkedList<Integer>();
		Queue<Integer> YStack = new LinkedList<Integer>();

		while (true) {
			for (int i = 0; i < 8; i++) {  // loop all the eight neighbors
				if (isSafe(x + rowNbr[i], y + colNbr[i])) {
					Xstack.add(x + rowNbr[i]); // add the x coordinate whose value is set to 1
					YStack.add(y + colNbr[i]);// add the y coordinate whose value is set to 1
				}
			}
			islandArray[x][y] = 0; // set the visited node to 0

			if (Xstack.isEmpty() && YStack.isEmpty())
				break; // when you find all 0s;

			x = Xstack.remove(); // remove from the head and loop again
			y = YStack.remove();
		}
	}

	public int findNumberOfIslands() {
		int numberOfIslands = 0;

		for (int x = 0; x < islandArray.length; x++) {
			for (int y = 0; y < islandArray[0].length; y++) {
				if (islandArray[x][y] == 1) {
					this.isConnectedPresent(x, y);
					numberOfIslands++;
				}
			}
		}
		System.out.println("Number of Islands present : " + numberOfIslands);
		return 0;
	}

	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		FindNumberOfIslands n = new FindNumberOfIslands();
		n.findNumberOfIslands();
	}
}