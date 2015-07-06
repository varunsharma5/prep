package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * A vertex in an undirected connected graph is an articulation point (or cut
 * vertex) iff removing it (and edges through it) disconnects the graph.
 * Articulation points represent vulnerabilities in a connected network – single
 * points whose failure would split the network into 2 or more disconnected
 * components.
 * 
 * http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * 
 * @author ajitkoti
 *
 */
public class ArticulationPointsInAGraph {
	Graph graph = null;
	
	static int time = 0;

	protected ArticulationPointsInAGraph(Graph xGraph) {
		graph = xGraph;	
	}

	// A recursive function that find articulation points using DFS traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	// ap[] --> Store articulation points
	public void APUtil(int u, int disc[], int low[], int parent[],	boolean ap[]) {
		// A static variable is used for simplicity, we can avoid use of static
		// variable by passing a pointer.

		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		graph.vertexList[u].wasVisited = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;
		int temp;
		// Go through all vertices aadjacent to this
		while ((temp = graph.getAdjUnVisitedVertex(u)) != -1) {
			int v = temp; // v is current adjacent of u

			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!graph.vertexList[v].wasVisited) {
				children++;
				parent[v] = u;
				APUtil(v, disc, low, parent, ap);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[u] == 0 && children > 1)
					ap[u] = true;

				// (2) If u is not root and low value of one of its child is
				// more
				// than discovery value of u.
				if (parent[u] != 0 && low[v] >= disc[u])
					ap[u] = true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}
}
