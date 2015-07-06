package com.interview.algorithms.graph;

import com.example.datastructures.weighted.graph.WeightedGraph;

/**
 * iven a graph and a source vertex src in graph, find shortest paths from src
 * to all vertices in the given graph. The graph may contain negative weight
 * edges. We have discussed Dijkstraâ€™s algorithm for this problem. Dijksraâ€™s
 * algorithm is a Greedy algorithm and time complexity is O(VLogV) (with the use
 * of Fibonacci heap). Dijkstra doesnâ€™t work for Graphs with negative weight
 * edges, Bellman-Ford works for such graphs. Bellman-Ford is also simpler than
 * Dijkstra and suites well for distributed systems. But time complexity of
 * Bellman-Ford is O(VE), which is more than Dijkstra.
 * 
 * Following are the detailed steps.
 * 
 * Input: Graph and a source vertex src Output: Shortest distance to all
 * vertices from src. If there is a negative weight cycle, then shortest
 * distances are not calculated, negative weight cycle is reported.
 * 
 * 1) This step initializes distances from source to all vertices as infinite
 * and distance to source itself as 0. Create an array dist[] of size |V| with
 * all values as infinite except dist[src] where src is source vertex.
 * 
 * 2) This step calculates shortest distances. Do following |V|-1 times where
 * |V| is the number of vertices in given graph. â€¦..a) Do following for each
 * edge u-v â€¦â€¦â€¦â€¦â€¦â€¦If dist[v] > dist[u] + weight of edge uv, then update dist[v]
 * â€¦â€¦â€¦â€¦â€¦â€¦â€¦.dist[v] = dist[u] + weight of edge uv
 * 
 * 3) This step reports if there is a negative weight cycle in graph. Do
 * following for each edge u-v â€¦â€¦If dist[v] > dist[u] + weight of edge uv, then
 * â€œGraph contains negative weight cycleâ€� The idea of step 3 is, step 2
 * guarantees shortest distances if graph doesnâ€™t contain negative weight cycle.
 * If we iterate through all edges one more time and get a shorter path for any
 * vertex, then there is a negative weight cycle
 * 
 * How does this work? Like other Dynamic Programming Problems, the algorithm
 * calculate shortest paths in bottom-up manner. It first calculates the
 * shortest distances for the shortest paths which have at-most one edge in the
 * path. Then, it calculates shortest paths with at-nost 2 edges, and so on.
 * After the ith iteration of outer loop, the shortest paths with at most i
 * edges are calculated. There can be maximum |V| â€“ 1 edges in any simple path,
 * that is why the outer loop runs |v| â€“ 1 times. The idea is, assuming that
 * there is no negative weight cycle, if we have calculated shortest paths with
 * at most i edges, then an iteration over all edges guarantees to give shortest
 * path with at-most (i+1) edges
 * 
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-
 * algorithm/
 * 
 * https://www.youtube.com/watch?v=Ttezuzs39nk
 * 
 * @author ajitkoti
 *
 */
public class ShortestPathUsingBellmanFordAlgorithm {

	private static WeightedGraph wgraph;

	// The main function that finds shortest distances from src to all other
	// vertices using Bellman-Ford algorithm. The function also detects negative
	// weight cycle
	static void BellmanFord() {
		int src = 0;
		int V = wgraph.vertexList.length;
		int E = 8;
		int dist[] = new int[V];

		// Step 1: Initialize distances from src to all other vertices as
		// INFINITE
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple shortest path from
		// src
		// to any other vertex can have at-most |V| - 1 edges
		for (int i = 1; i <= V - 1; i++) {
			for (int j = 0; j < E; j++) {
				int weight = wgraph.adjMat[i][j];
				if (dist[i] + weight < dist[j])
					dist[j] = dist[i] + weight;
			}
		}

		return;
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		wgraph = new WeightedGraph();
		/* Let us create the graph given in above example */
		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph

		wgraph.addVertex('A'); // 0
		wgraph.addVertex('B'); // 1
		wgraph.addVertex('C'); // 2
		wgraph.addVertex('D'); // 3
		wgraph.addVertex('E'); // 4

		wgraph.addEdge(0, 1, -1); // AB -1
		wgraph.addEdge(0, 2, 4); // Ac 4
		wgraph.addEdge(1, 2, 3); // BC 10
		wgraph.addEdge(1, 3, 2); // BD 2
		wgraph.addEdge(1, 4, 2); // BE 7
		wgraph.addEdge(3, 2, 5); // DC 5
		wgraph.addEdge(3, 1, 1); // DB 1
		wgraph.addEdge(4, 3, -3); // ED 5

		BellmanFord();

//		return 0;
	}

}
