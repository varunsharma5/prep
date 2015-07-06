package com.interview.algorithms.graph;

import com.example.datastructures.Queue;
import com.example.datastructures.graph.BreadthFirstSearch;
import com.example.datastructures.graph.Graph;

/**
 * Given a Directed Graph and two vertices in it, check whether there is a path
 * from the first given vertex to second
 * 
 * We can either use Breadth First Search (BFS) or Depth First Search (DFS) to
 * find path between two vertices. Take the first vertex as source in BFS (or
 * DFS), follow the standard BFS (or DFS). If we see the second vertex in our
 * traversal, then return true. Else return false.
 * 
 * http://www.geeksforgeeks.org/find
 * -if-there-is-a-path-between-two-vertices-in-a-given-graph/
 * 
 * @author ajitkoti
 *
 */
public class FindIfPathExistsBetweenTwoVerticesOfGraph {
	Graph graph = null;
	Queue<Integer> queue = null;

	protected FindIfPathExistsBetweenTwoVerticesOfGraph(Graph xGraph) {
		graph = xGraph;
		queue = new Queue<Integer>(10);

	}

	/**
	 * Using BFS
	 * 
	 * @param src
	 * @param dest
	 * @return
	 */
	public boolean isReachable(int src, int dest) {
		graph.vertexList[src].wasVisited = true;
		queue.insert(src);		
		int temp;

		while (!queue.isEmpty()) {
			src = queue.remove();
			while ((temp = graph.getAdjUnVisitedVertex(src)) != -1) {
				if (temp == dest) {
					return true;
				}
				graph.vertexList[temp].wasVisited = true;				
				queue.insert(temp);

			}
		}
		return false;

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
