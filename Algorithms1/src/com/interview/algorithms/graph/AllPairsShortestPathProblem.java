package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path
 * problem. The problem is to find shortest distances between every pair of
 * vertices in a given edge weighted directed Graph.
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-
 * algorithm/
 * 
 * @author ajitkoti
 *
 */
public class AllPairsShortestPathProblem {

	// Solves the all-pairs shortest path problem using Floyd Warshall algorithm
	void floydWarshell(Graph graph) {
		/*
		 * dist[][] will be the output matrix that will finally have the
		 * shortest distances between every pair of vertices
		 */
		int i, j, k;

		int dist[][] = new int[graph.getAdjMatrix().length][graph
				.getAdjMatrix()[0].length];

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can
		 * say the initial values of shortest distances are based on shortest
		 * paths considering no intermediate vertex.
		 */
		for (i = 0; i < graph.getAdjMatrix().length; i++)
			for (j = 0; j < graph.getAdjMatrix().length; j++)
				dist[i][j] = graph.getAdjMatrix()[i][j];

		/*
		 * Add all vertices one by one to the set of intermediate vertices. --->
		 * Before start of a iteration, we have shortest distances between all
		 * pairs of vertices such that the shortest distances consider only the
		 * vertices in set {0, 1, 2, .. k-1} as intermediate vertices. ---->
		 * After the end of a iteration, vertex no. k is added to the set of
		 * intermediate vertices and the set becomes {0, 1, 2, .. k}
		 */
		for (k = 0; k < graph.getAdjMatrix().length; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < graph.getAdjMatrix().length; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < graph.getAdjMatrix().length; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(dist);
	}

	/* A utility function to print solution */
	void printSolution(int dist[][]) {
		System.out
				.println("Following matrix shows the shortest distances between every pair of vertices");
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				System.out.println(dist[i][j]);

			}

		}
	}

}
