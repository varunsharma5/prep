package com.interview.algorithms.graph;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex
 * exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian
 * Path such that there is an edge (in graph) from the last vertex to the first
 * vertex of the Hamiltonian Path. Determine whether a given graph contains
 * Hamiltonian Cycle or not. If it contains, then print the path. Following are
 * the input and output of the required function.
 * 
 * For example, a Hamiltonian Cycle in the following graph is {0, 1, 2, 4, 3, 0}. 
 * There are more Hamiltonian Cycles in the graph like {0, 3, 4, 2, 1, 0}

(0)--(1)--(2)
 |   / \   |
 |  /   \  | 
 | /     \ |
(3)-------(4)
 * 
 * http://en.wikipedia.org/wiki/Hamiltonian_path
 * http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 * 
 * @author ajitkoti
 * 
 */
public class HamiltonianCycle {
	private int V, pathCount;
	private int[] path;
	private int[][] graph;

	/** Function to find cycle **/
	public void findHamiltonianCycle(int[][] g) {	
		graph = g;
		path = new int[graph.length];

		Arrays.fill(path, -1);
		
		try {
			path[0] = 0;
			pathCount = 1;
			solve(0);
			System.out.println("No solution");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			display();
		}
	}

	/** function to find paths recursively **/
	public void solve(int vertex) throws Exception {
		/** solution **/
		if (graph[vertex][0] == 1 && pathCount == graph.length)
			throw new Exception("Solution found");
		/** all vertices selected but last vertex not linked to 0 **/
		if (pathCount == graph.length)
			return;

		for (int v = 0; v < graph.length; v++) {
			/** if connected **/
			if (graph[vertex][v] == 1) {
				/** add to path **/
				path[pathCount++] = v;
				/** remove connection **/
				graph[vertex][v] = 0;
				graph[v][vertex] = 0;

				/** if vertex not already selected solve recursively **/
				if (!isPresent(v))
					solve(v);

				/** restore connection **/
				graph[vertex][v] = 1;
				graph[v][vertex] = 1;
				/** remove path **/
				path[--pathCount] = -1;
			}
		}
	}

	/** function to check if path is already selected **/
	public boolean isPresent(int v) {
		for (int i = 0; i < pathCount - 1; i++)
			if (path[i] == v)
				return true;
		return false;
	}

	/** display solution **/
	public void display() {
		System.out.print("\nPath : ");
		for (int i = 0; i <= V; i++)
			System.out.print(path[i % V] + " ");
		System.out.println();
	}

	/** Main function **/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("HamiltonianCycle Algorithm Test\n");
		/** Make an object of HamiltonianCycle class **/
		HamiltonianCycle hc = new HamiltonianCycle();

		/** Accept number of vertices **/
		System.out.println("Enter number of vertices\n");
		int V = scan.nextInt();

		/** get graph **/
		System.out.println("\nEnter matrix\n");
		int[][] graph = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				graph[i][j] = scan.nextInt();

		hc.findHamiltonianCycle(graph);
	}
}