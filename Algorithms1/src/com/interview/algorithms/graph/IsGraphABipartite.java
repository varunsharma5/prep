package com.interview.algorithms.graph;

import com.example.datastructures.Queue;

/**
 * A Bipartite Graph is a graph whose vertices can be divided into two
 * independent sets, U and V such that every edge (u, v) either connects a
 * vertex from U to V or a vertex from V to U. In other words, for every edge (u,
 * v), either u belongs to U and v to V, or u belongs to V and v to U. We can
 * also say that there is no edge that connects vertices of same set
 * 
 * http://www.geeksforgeeks.org/bipartite-graph/
 * @author ajitkoti
 *
 */
public class IsGraphABipartite {

	// This function returns true if graph G[V][V] is Bipartite, else false
	boolean isBipartite(int G[][], int src) {
		// Create a color array to store colors assigned to all veritces. Vertex
		// number is used as index in this array. The value '-1' of colorArr[i]
		// is used to indicate that no color is assigned to vertex 'i'. The
		// value
		// 1 is used to indicate first color is assigned and value 0 indicates
		// second color is assigned.
		int colorArr[] = new int[G.length];
		for (int i = 0; i < G.length; ++i)
			colorArr[i] = -1;

		// Assign first color to source
		colorArr[src] = 1;

		// Create a queue (FIFO) of vertex numbers and enqueue source vertex
		// for BFS traversal
		Queue<Integer> q = new Queue<Integer>();
		q.insert(src);

		// Run while there are vertices in queue (Similar to BFS)
		while (!q.isEmpty()) {
			// Dequeue a vertex from queue ( Refer http://goo.gl/35oz8 )
			int u = q.remove();

			// Find all non-colored adjacent vertices
			for (int v = 0; v < G.length; ++v) {
				// An edge from u to v exists and destination v is not colored
				if (G[u][v] == 1 && colorArr[v] == -1) {
					// Assign alternate color to this adjacent v of u
					colorArr[v] = 1 - colorArr[u];
					q.insert(v);
				}else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) {
					// An edge from u to v exists and destination v is colored with/ same color as u
					return false;
				}
			}
		}

		// If we reach here, then all adjacent vertices can be colored with
		// alternate color
		return true;
	}

}
