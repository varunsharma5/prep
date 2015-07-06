package com.interview.algorithms.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * A group of farmers has some elevation data, and we’re going to help them
 * understand how rainfall flows over their farmland. We’ll represent the land
 * as a two-dimensional array of altitudes and use the following model, based on
 * the idea that water flows downhill:
 * 
 * If a cell’s four neighboring cells all have higher altitudes, we call this
 * cell a sink; water collects in sinks. Otherwise, water will flow to the
 * neighboring cell with the lowest altitude. If a cell is not a sink, you may
 * assume it has a unique lowest neighbor and that this neighbor will be lower
 * than the cell.
 * 
 * Cells that drain into the same sink – directly or indirectly – are said to be
 * part of the same basin.
 * 
 * Your challenge is to partition the map into basins. In particular, given a
 * map of elevations, your code should partition the map into basins and output
 * the sizes of the basins, in descending order.
 * 
 * Assume the elevation maps are square. Input will begin with a line with one
 * integer, S, the height (and width) of the map. The next S lines will each
 * contain a row of the map, each with S integers – the elevations of the S
 * cells in the row. Some farmers have small land plots such as the examples
 * below, while some have larger plots. However, in no case will a farmer have a
 * plot of land larger than S = 5000.
 * 
 * Your code should output a space-separated list of the basin sizes, in
 * descending order. (Trailing spaces are ignored.)
 * 
 * While correctness and performance are the most important parts of this
 * problem, a human will be reading your solution, so please make an effort to
 * submit clean, readable code. In particular, do not write code as if you were
 * solving a problem for a competition.
 * 
 * A few examples are below.
 * 
 * Input: 3 1 5 2 2 4 7 3 6 9
 * 
 * 
 * Output: 7 2
 * 
 * http://www.careercup.com/question?id=15380670
 * http://www.geeksforgeeks.org/flipkart-interview-set-2-for-sde-1/
 * 
 * @author ajitkoti
 *
 */
public class FindMaxBasin {

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter square size : ");
		String line = reader.readLine();
		int size = Integer.parseInt(line);
		int area[][] = new int[size][size];

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print("(" + x + "," + y + ")" + " : ");
				line = reader.readLine();
				area[x][y] = Integer.parseInt(line.trim());
			}
		}
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(area[x][y] + " ");
			}
			System.out.println("");
		}

		calculateBasins(area);
		System.out.println("DONE");
	}

	public static void calculateBasins(int area[][]) {
		int size = area.length;
		String basins[][] = new String[size][size];
		HashMap map = new HashMap();
		char uniqueChar = 'A';
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				basins[x][y] = lowestPlot(area, x, y, 'A');
				if (map.containsKey(basins[x][y])) {
					String valueString = (String) map.get(basins[x][y]);
					StringTokenizer tokens = new StringTokenizer(valueString,
							":");
					char basinUniqueueChar = tokens.nextToken().charAt(0);
					int basinSize = Integer.parseInt(tokens.nextToken());
					basinSize = basinSize + 1;
					map.put(basins[x][y], basinUniqueueChar + ":" + basinSize);
				} else {
					map.put(basins[x][y], uniqueChar + ":" + 1);
					uniqueChar++;
				}
			}
		}

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				System.out.print(map.get(basins[x][y]) + " ");
			}
			System.out.println("");
		}
	}

	public static String lowestPlot(int area[][], int x, int y, char ch) {
		String lowestPoint = x + "," + y;
		int size = area.length;
		int leftX, leftY, rightX, rightY, topX, topY, bottomX, bottomY;
		int minX, minY, minValue;

		leftX = x;
		leftY = y - 1;

		rightX = x;
		rightY = y + 1;

		topX = x - 1;
		topY = y;

		bottomX = x + 1;
		bottomY = y;

		minX = x;
		minY = y;
		minValue = area[x][y];

		if (!isOutOfBounds(leftX, leftY, size)) {
			if (area[leftX][leftY] < minValue) {
				minX = leftX;
				minY = leftY;
				minValue = area[leftX][leftY];
			}
		}
		if (!isOutOfBounds(rightX, rightY, size)) {
			if (area[rightX][rightY] < minValue) {
				minX = rightX;
				minY = rightY;
				minValue = area[rightX][rightY];
			}
		}
		if (!isOutOfBounds(topX, topY, size)) {
			if (area[topX][topY] < minValue) {
				minX = topX;
				minY = topY;
				minValue = area[topX][topY];
			}
		}
		if (!isOutOfBounds(bottomX, bottomY, size)) {
			if (area[bottomX][bottomY] < minValue) {
				minX = bottomX;
				minY = bottomY;
				minValue = area[bottomX][bottomY];
			}
		}
		if (minX == x && minY == y) {
			// self is the lowest;
		} else {
			lowestPoint = lowestPlot(area, minX, minY, ch);
		}
		return lowestPoint;
	}

	public static boolean isOutOfBounds(int x, int y, int size) {
		boolean flag = false;
		if (x < 0 || x >= size) {
			flag = true;
		}
		if (y < 0 || y >= size) {
			flag = true;
		}
		return flag;
	}

}
