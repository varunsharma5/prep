package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * Given a directed graph, find out if a vertex j is reachable from another
 * vertex i for all vertex pairs (i, j) in the given graph. Here reachable mean
 * that there is a path from vertex i to j. The reach-ability matrix is called
 * transitive closure of a graph. The graph is given in the form of adjacency
 * matrix say ‘graph[V][V]‘ where graph[i][j] is 1 if there is an edge from
 * vertex i to vertex j or i is equal to j, otherwise graph[i][j] is 0.
 * 
 * Floyd Warshall Algorithm can be used, we can calculate the distance matrix
 * dist[V][V] using Floyd Warshall, if dist[i][j] is infinite, then j is not
 * reachable from i, otherwise j is reachable and value of dist[i][j] will be
 * less than V. Instead of directly using Floyd Warshall, we can optimize it in
 * terms of space and time, for this particular problem.
 * 
 * http://www.geeksforgeeks.org/transitive-closure-of-a-graph/
 * 
 * @author ajitkoti
 *
 */
public class TransitiveClosureOfAGraph {

	// Prints transitive closure of graph[][] using Floyd Warshall algorithm
	void transitiveClosure(Graph graph) {
		/*
		 * reach[][] will be the output matrix that will finally have the
		 * shortest distances between every pair of vertices
		 */
		int i, j, k;
		int reach[][] = new int[graph.adjMatrix.length][graph.adjMatrix.length];

		/*
		 * Initialize the solution matrix same as input graph matrix. Or we can
		 * say the initial values of shortest distances are based on shortest
		 * paths considering no intermediate vertex.
		 */
		for (i = 0; i < graph.adjMatrix.length; i++)
			for (j = 0; j < graph.adjMatrix[0].length; j++)
				reach[i][j] = graph.adjMatrix[i][j];

		/*
		 * Add all vertices one by one to the set of intermediate vertices. --->
		 * Before start of a iteration, we have reachability values for all
		 * pairs of vertices such that the reachability values consider only the
		 * vertices in set {0, 1, 2, .. k-1} as intermediate vertices. ---->
		 * After the end of a iteration, vertex no. k is added to the set of
		 * intermediate vertices and the set becomes {0, 1, 2, .. k}
		 */
		for (k = 0; k < graph.adjMatrix.length; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < graph.adjMatrix[0].length; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < graph.adjMatrix[0].length; j++) {
					// If vertex k is on a path from i to j,
					// then make sure that the value of reach[i][j] is 1
					if ((reach[i][k] == 1 && reach[k][j] == 1)
							|| reach[i][j] == 1) {
						reach[i][j] = 1;
					}
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(reach);
	}

	void printSolution(int reach[][]) {
		System.out
				.println("Following matrix is transitive closure of the given graph");
		for (int i = 0; i < reach.length; i++) {
			for (int j = 0; j < reach[0].length; j++)
				System.out.println(reach[i][j]);

		}
	}

}
