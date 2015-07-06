package com.interview.algorithms.graph;

import com.example.datastructures.Stack;
import com.example.datastructures.graph.Graph;

/**
 * Given a directed graph, find out whether the graph is strongly connected or
 * not. A directed graph is strongly connected if there is a path between any
 * two pair of vertices. For example, following is a strongly connected graph.
 * 
 * It is easy for undirected graph, we can just do a BFS and DFS starting from
 * any vertex. If BFS or DFS visits all vertices, then the given undirected
 * graph is connected. This approach won’t work for a directed graph.
 * http://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
 * 
 * 
 * How to do for directed graph? A simple idea is to use a all pair shortest
 * path algorithm like Floyd Warshall or find Transitive Closure of graph. Time
 * complexity of this method would be O(v3).
 * 
 * We can also do DFS V times starting from every vertex. If any DFS, doesn’t
 * visit all vertices, then graph is not strongly connected. This algorithm
 * takes O(V*(V+E)) time which can be same as transitive closure for a dense
 * graph.
 * 
 * A better idea can be Strongly Connected Components (SCC) algorithm. We can
 * find all SCCs in O(V+E) time. If number of SCCs is one, then graph is
 * strongly connected. The algorithm for SCC does extra work as it finds all
 * SCCs.
 * 
 * Following is Kosaraju’s DFS based simple algorithm that does two DFS
 * traversals of graph:
 * 
 * 1) Initialize all vertices as not visited.
 * 
 * 2) Do a DFS traversal of graph starting from any arbitrary vertex v. If DFS
 * traversal doesn’t visit all vertices, then return false.
 * 
 * 3) Reverse all arcs (or find transpose or reverse of graph)
 * 
 * 4) Mark all vertices as not-visited in reversed graph.
 * 
 * 5) Do a DFS traversal of reversed graph starting from same vertex v (Same as
 * step 2). If DFS traversal doesn’t visit all vertices, then return false.
 * Otherwise return true.
 * 
 * The idea is, if every node can be reached from a vertex v, and every node can
 * reach v, then the graph is strongly connected. In step 2, we check if all
 * vertices are reachable from v. In step 4, we check if all vertices can reach
 * v (In reversed graph, if all vertices are reachable from v, then all vertices
 * can reach v in original graph).
 * 
 * @author ajitkoti
 *
 */
public class ConnectivityInADirectedGraph {
	Graph graph = null;
	Stack<Integer> stack = null;

	protected ConnectivityInADirectedGraph(Graph xGraph) {
		graph = xGraph;
		stack = new Stack<Integer>(10);
	}

	/**
	 * Using BFS
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public boolean isReachable(int src, int dest) {
		int vertexLength = graph.getVertexList().length;
		dfs(0);

		// If DFS traversal doesn’t visit all vertices, then return false.
		for (int i = 0; i < graph.getVertexList().length; i++)
			if (graph.getVertexList()[i].wasVisited == false)
				return false;

		// Step 3: Create a reversed graph
		transposeMatrix(graph);

		// Step 4: Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < vertexLength; i++)
			graph.getVertexList()[i].wasVisited = false;

		dfs(0);

		// If DFS traversal doesn’t visit all vertices, then return false.
		for (int i = 0; i < graph.getVertexList().length; i++)
			if (graph.getVertexList()[i].wasVisited == false)
				return false;

		return true;

	}

	private void transposeMatrix(Graph graph2) {
		int transpose[][] = new int[graph.getAdjMatrix().length][graph.getAdjMatrix()[0].length];

		for (int c = 0; c < graph.getAdjMatrix().length; c++) {
			for (int d = 0; d < graph.getAdjMatrix()[0].length; d++)
				transpose[d][c] = graph.getAdjMatrix()[c][d];
		}

		graph.setAdjMatrix(transpose);
	}

	public void dfs(int index) {
		graph.getVertexList()[index].wasVisited = true;
		graph.displayVertex(index);
		stack.push(index);

		while (!stack.isEmpty()) {
			int v = graph.getAdjUnVisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			} else {
				graph.getVertexList()[v].wasVisited = true;
				graph.displayVertex(v);
				stack.push(v);

			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(10);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 4);
		FindIfPathExistsBetweenTwoVerticesOfGraph pathExists = new FindIfPathExistsBetweenTwoVerticesOfGraph(
				graph);

		System.out.println("Is Paths Reacahble: "
				+ pathExists.isReachable(1, 3));

	}

}
