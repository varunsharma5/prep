package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;

/**
 * Given a directed graph, check whether the graph contains a cycle or not. Your
 * function should return true if the given graph contains at least one cycle,
 * else return false. For example, the following graph contains three cycles
 * 0->2->0, 0->1->2->0 and 3->3, so your function must return true.
 * 
 * Solution Depth First Traversal can be used to detect cycle in a Graph. DFS
 * for a connected graph produces a tree. There is a cycle in a graph only if
 * there is a back edge present in the graph. A back edge is an edge that is
 * from a node to itself (selfloop) or one of its ancestor in the tree produced
 * by DFS.
 * 
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * 
 * @author ajitkoti
 *
 */
public class DetectCycleInADirectedGraph {

	private static boolean isCyclicUtil(int start, Graph graph) {
		graph.getVertexList()[start].wasVisited = true;
		for (int j = 0; j < graph.noOfVerts; j++) {
			if (graph.getAdjMatrix()[start][j] == 1
					&& (graph.getVertexList()[j].wasVisited || isCyclicUtil(j,
							graph)))
				return true;
		}
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	// This function is a variation of DFS() in
	// http://www.geeksforgeeks.org/archives/18212
	private static boolean isCyclic() {
		Graph graph = new Graph(5);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 4);
		// Call the recursive helper function to detect cycle in different
		// DFS trees
		for (int i = 0; i < 5; i++)
			if (isCyclicUtil(i, graph))
				return true;

		return false;
	}

	public static void main(String[] args) {
		System.out.println("Is Graph Cyclic" + isCyclic());

	}

}
