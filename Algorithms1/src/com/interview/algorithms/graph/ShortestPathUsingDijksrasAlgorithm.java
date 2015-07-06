package com.interview.algorithms.graph;

import com.example.datastructures.weighted.graph.WeightedGraph;

public class ShortestPathUsingDijksrasAlgorithm {

	private static WeightedGraph graph;
	private static int currentVert; // current vertex
	private static int startToCurrent; // distance to currentVert
	private static int nTree; // # of verts in tree
	private static DistPar sPath[]; // array for shortest-path data

	public static void path() {
		// start at first vertex (0)
		int startTree = 0;

		// Put first vertex in the tree
		graph.vertexList[startTree].isInTree = true;
		nTree = 1;

		// Transfer initial row of distances from adj matrix to sPath
		// We'll be updating sPath as we build out our shortest path list
		for (int j = 0; j < graph.nVerts; j++) {
			int tempDist = graph.adjMat[startTree][j];
			sPath[j] = new DistPar(startTree, tempDist);
		}

		// Until all vertices are in the tree...
		while (nTree < graph.nVerts) {
			// find shortest distance to unvisited vertex
			int indexMin = getMin(); // find min index
			int minDist = sPath[indexMin].distance; // store min value

			if (minDist == graph.INFINITY) // all infinite distances OR
			{ // all vertexes are in tree
				System.out.println("There are unreachable vertices");
				break;
			} else {
				currentVert = indexMin; // set to closest vert
				startToCurrent = sPath[indexMin].distance;
			}

			// Put current vertex in tree
			graph.vertexList[currentVert].isInTree = true;
			nTree++;
			// Update sPath array
			adjust_sPath();
		}

		// Print output to screen
		displayPaths();

		// Clear Tree
		nTree = 0;
		for (int j = 0; j < graph.nVerts; j++)
			graph.vertexList[j].isInTree = false;
	}

	// -------------------------------------------------------------------
	public static int getMin() {
		int minDist = graph.INFINITY; // assume minimum for now
		int indexMin = 0; // we'll eventually return this var
		for (int j = 1; j < graph.nVerts; j++) // for each vert
		{
			// if its not in the tree & smaller than stored min...
			if (!graph.vertexList[j].isInTree && sPath[j].distance < minDist) {
				minDist = sPath[j].distance; // update min distance
				indexMin = j; // update index of min
			}
		}
		return indexMin;
	}

	// -------------------------------------------------------------------
	public static void adjust_sPath() {
		// adjust values in shortest-path array sPath
		int column = 1; // skip starting vertex
		while (column < graph.nVerts) // go across columns
		{
			// Skip if column's vertex is already in the tree
			if (graph.vertexList[column].isInTree) {
				column++;
				continue;
			}

			// The length of current leg of the path
			int currentToFringe = graph.adjMat[currentVert][column];
			// The length of the full path
			int startToFringe = startToCurrent + currentToFringe;

			// Update sPath with smaller values if available
			int sPathDist = sPath[column].distance;
			if (startToFringe < sPathDist) {
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}

	// -------------------------------------------------------------------
	public static void displayPaths() // display contents of sPath
	{
		for (int j = 0; j < graph.nVerts; j++) {
			// Print label + distance
			System.out.print(graph.vertexList[j].label + "=");
			if (sPath[j].distance == graph.INFINITY)
				System.out.print("inf");
			else
				System.out.print(sPath[j].distance);

			// Print last vertex touched before destination is reached
			char parent = graph.vertexList[sPath[j].parentVert].label;
			System.out.print("(" + parent + ") ");
		}
		System.out.println("");
	}

	// -------------------------------------------------------------------

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.addVertex('A'); // 0
		graph.addVertex('B'); // 1
		graph.addVertex('C'); // 2
		graph.addVertex('D'); // 3
		graph.addVertex('E'); // 4

		graph.addEdge(0, 1, 50); // AB 50
		graph.addEdge(0, 3, 80); // AD 80
		graph.addEdge(1, 2, 60); // BC 60
		graph.addEdge(1, 3, 90); // BD 90
		graph.addEdge(2, 4, 40); // CE 40
		graph.addEdge(3, 2, 20); // DC 20
		graph.addEdge(3, 4, 70); // DE 70
		graph.addEdge(4, 1, 50); // EB 50

		System.out.println("Shortest path");
		path();
		System.out.println();
	}

}

class DistPar // distance and parent
{ // objects stored in sPath array
	public int distance; // distance from start to this vertex
	public int parentVert; // current parent of this vertex

	// -------------------------------------------------------------------

	public DistPar(int pv, int d) {
		distance = d;
		parentVert = pv;
	}
}