package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * An undirected graph is called Biconnected if there are two vertex-disjoint
 * paths between any two vertices. In a Biconnected Graph, there is a simple
 * cycle through any two vertices. By convention, two nodes connected by an edge
 * form a biconnected graph, but this does not verify the above properties. For
 * a graph with more than two vertices, the above properties must be there for
 * it to be Biconnected.
 * 
 * http://www.geeksforgeeks.org/biconnectivity-in-a-graph/
 * 
 * @author ajitkoti
 *
 */
public class IsAGraphBiconnectied {

	Graph graph = null;
	static int time = 0;

	protected IsAGraphBiconnectied(Graph xGraph) {
		graph = xGraph;
	}

	private boolean isBC() {

		int[] disc = new int[10];
		int[] low = new int[10];
		int[] parent = new int[10];

		// Call the recursive helper function to find if there is an
		// articulation
		// point in given graph. We do DFS traversal starring from vertex 0
		if (APUtil(0, disc, low, parent) == true)
			return false;
		// Now check whether the given graph is connected or not. An undirected
		// graph is connected if all vertices are reachable from any starting
		// point (we have taken 0 as starting point)
		for (int i = 0; i < graph.vertexList.length; i++)
			if (graph.vertexList[i].wasVisited == false)
				return false;

		return true;
	}

	// A recursive function that find articulation points using DFS traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	// ap[] --> Store articulation points
	public boolean APUtil(int u, int disc[], int low[], int parent[]) {
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
				APUtil(v, disc, low, parent);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[u] == 0 && children > 1)
					return true;

				// (2) If u is not root and low value of one of its child is
				// more
				// than discovery value of u.
				if (parent[u] != 0 && low[v] >= disc[u])
					return true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
		return false;
	}

}