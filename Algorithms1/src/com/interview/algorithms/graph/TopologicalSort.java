package com.interview.algorithms.graph;

import com.example.datastructures.graph.Graph;
/**
 * From Data Structures & Algorithms By Robert Lafore
 * @author ajitkoti
 *
 */
public class TopologicalSort {
	
	private static Graph graph;
	private static int MAX_VERTS;
	// For sorted vert labes
	private static char[] sortedArray;

	private static void topo() // topological sort
	{
		int orig_nVerts = MAX_VERTS; // remember how many verts

		while (MAX_VERTS > 0) {
			// get a vertex with no successors or -1
			int currentVertex = noSuccessors();
			if (currentVertex == -1) // must be a cycle
			{
				System.out.println("ERROR: Graph has cycles");
				return;
			}

			// insert vertex label in sorted array (we begin at end)
			sortedArray[MAX_VERTS - 1] = graph.getVertexList()[currentVertex].label;

			// delete vertex
			deleteVertex(currentVertex);
		}

		// Vertices are all gone--> display sorted array
		System.out.print("Topologically sorted order: ");
		for (int j = 0; j < orig_nVerts; j++)
			System.out.print(sortedArray[j]);
		System.out.println("");
	}

	// -----------------------------------------------------------
	private static int noSuccessors() // returns vert with no successors
	{
		boolean isEdge; // edge from row to column in adjMat

		/*
		 * For each row, go through each column If you find a 1, the row is an
		 * edge (has successors) If you don't find any 1s in a row, is not an
		 * edge--return it If you don't find any non-edges, there must be a
		 * cycle (return -1)
		 */

		for (int row = 0; row < MAX_VERTS; row++) {
			isEdge = false;
			for (int col = 0; col < MAX_VERTS; col++) {
				if (graph.getAdjMatrix()[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge)
				return row;
		}
		return -1;
	}

	// -----------------------------------------------------------
	private static void deleteVertex(int delVert) {
		if (delVert != MAX_VERTS - 1)
		/*
		 * we only need to perform the enclosed operations if we're not deleting
		 * the last element
		 */
		{
			// shift elements forward that are beyond deleted element
			for (int j = delVert; j < MAX_VERTS - 1; j++)
				graph.vertexList[j] = graph.vertexList[j + 1];
			// Handle Adjacency Matrix

			// Delete Row from Adjacency Matrix
			for (int row = delVert; row < MAX_VERTS - 1; row++)
				moveRowUp(row, MAX_VERTS);

			// Delete Column from Adjacency Matrix
			for (int col = delVert; col < MAX_VERTS - 1; col++)
				moveColLeft(col, MAX_VERTS - 1);
		}
		MAX_VERTS--;
	}

	// -----------------------------------------------------------
	private static void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++)
			// we need all the columns
			graph.getAdjMatrix()[row][col] = graph.getAdjMatrix()[row + 1][col]; // but
																					// not
																					// all
																					// rows
	}

	// -----------------------------------------------------------
	private static void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++)
			// we need all the rows
			graph.getAdjMatrix()[row][col] = graph.getAdjMatrix()[row][col + 1]; // but
																					// not
																					// all
																					// cols
	}

	// -----------------------------------------------------------

	private static void loadGraph() {
		MAX_VERTS = 7;
		sortedArray = new char[MAX_VERTS];

		graph = new Graph(MAX_VERTS);
		graph.addVertex('A'); // 0
		graph.addVertex('B'); // 1
		graph.addVertex('C'); // 2
		graph.addVertex('D'); // 3
		graph.addVertex('E'); // 4
		graph.addVertex('F'); // 5
		graph.addVertex('G'); // 6
		graph.addVertex('H'); // 7

		graph.addEdge(0, 3); // AD
		graph.addEdge(0, 4); // AE
		graph.addEdge(1, 4); // BE
		graph.addEdge(2, 5); // CF
		graph.addEdge(3, 6); // DG
		graph.addEdge(4, 6); // EG
		graph.addEdge(5, 7); // FH
		graph.addEdge(6, 7); // GH

	}

	public static void main(String[] args) {

		loadGraph();
		topo();

	}

}
