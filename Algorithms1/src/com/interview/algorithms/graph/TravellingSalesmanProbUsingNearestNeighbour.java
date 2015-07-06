package com.interview.algorithms.graph;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.datastructures.Stack;

/**
 * This Java Program is to Implement Traveling Salesman Problem using Nearest
 * Neighbor Algorithm.The Traveling salesman problem (TSP) or traveling
 * salesperson problem asks the following question: Given a list of cities and
 * the distances between each pair of cities, what is the shortest possible
 * route that visits each city exactly once and returns to the origin city? It
 * is an NP-hard problem in combinatorial optimization, important in operations
 * research and theoretical computer science.
 * 
 * http://en.wikipedia.org/wiki/Nearest_neighbour_algorithm
 * https://www.youtube.com/watch?v=RK6eu3jvKzw
 * 
 * @author ajitkoti
 *
 */
public class TravellingSalesmanProbUsingNearestNeighbour {
	private int numberOfNodes;
	private Stack<Integer> stack;

	public TravellingSalesmanProbUsingNearestNeighbour() {
		stack = new Stack<Integer>(100);
	}

	public void tsp(int adjacencyMatrix[][]) {
		numberOfNodes = adjacencyMatrix[1].length - 1;
		int[] visited = new int[numberOfNodes + 1];
		visited[1] = 1;
		stack.push(1);
		int element, dst = 0, i;
		int min = Integer.MAX_VALUE;
		boolean minFlag = false;
		System.out.print(1 + "\t");

		while (!stack.isEmpty()) {
			element = stack.peek();
			i = 1;
			min = Integer.MAX_VALUE;
			while (i <= numberOfNodes) {
				if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) {
					if (min > adjacencyMatrix[element][i]) {
						min = adjacencyMatrix[element][i];
						dst = i;
						minFlag = true;
					}
				}
				i++;
			}
			if (minFlag) {
				visited[dst] = 1;
				stack.push(dst);
				System.out.print(dst + "\t");
				minFlag = false;
				continue;
			}
			stack.pop();
		}
	}

	public static void main(String... arg) {
		int number_of_nodes;
		Scanner scanner = null;
		try {
			System.out.println("Enter the number of nodes in the graph");
			scanner = new Scanner(System.in);
			number_of_nodes = scanner.nextInt();
			int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
			System.out.println("Enter the adjacency matrix");
			for (int i = 1; i <= number_of_nodes; i++) {
				for (int j = 1; j <= number_of_nodes; j++) {
					adjacency_matrix[i][j] = scanner.nextInt();
				}
			}
			for (int i = 1; i <= number_of_nodes; i++) {
				for (int j = 1; j <= number_of_nodes; j++) {
					if (adjacency_matrix[i][j] == 1
							&& adjacency_matrix[j][i] == 0) {
						adjacency_matrix[j][i] = 1;
					}
				}
			}
			System.out.println("the citys are visited as follows");
			TravellingSalesmanProbUsingNearestNeighbour tspNearestNeighbour = new TravellingSalesmanProbUsingNearestNeighbour();
			tspNearestNeighbour.tsp(adjacency_matrix);
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input format");
		}
		scanner.close();
	}
}
