package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * An edge in an undirected connected graph is a bridge iff removing it
 * disconnects the graph. For a disconnected undirected graph, definition is
 * similar, a bridge is an edge removing which increases number of connected
 * components. Like Articulation Points,bridges represent vulnerabilities in a
 * connected network and are useful for designing reliable networks. For
 * example, in a wired computer network, an articulation point indicates the
 * critical computers and a bridge indicates the critical wires or connections.
 * 
 * http://www.geeksforgeeks.org/bridge-in-a-graph/
 * 
 * @author ajitkoti
 *
 */
public class BridgesInAGraph {
	Graph graph = null;
	static int time = 0;

	protected BridgesInAGraph(Graph xGraph) {
		graph = xGraph;
	}

	// A recursive function that finds and prints bridges using DFS traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	private void bridgeUtil(int u, int disc[], int low[], int parent[]) {

		// Mark the current node as visited
		graph.vertexList[u].wasVisited = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices aadjacent to this
		int temp;
		// Go through all vertices aadjacent to this
		while ((temp = graph.getAdjUnVisitedVertex(u)) != -1) {
			int v = temp; // v is current adjacent of u

			// If v is not visited yet, then recur for it
			if (!graph.vertexList[v].wasVisited) {
				parent[v] = u;
				bridgeUtil(v, disc, low, parent);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// If the lowest vertex reachable from subtree under v is
				// below u in DFS tree, then u-v is a bridge
				if (low[v] > disc[u])
					System.out.println("" + u + "-->" + v);
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	// DFS based function to find all bridges. It uses recursive function
	// bridgeUtil()
	private void bridge() {
		// Mark all the vertices as not visited
		int[] disc = new int[10];
		int[] low = new int[10];
		int[] parent = new int[10];

		// Call the recursive helper function to find Bridges
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < 10; i++)
			if (graph.vertexList[i].wasVisited == false)
				bridgeUtil(i, disc, low, parent);
	}

}
