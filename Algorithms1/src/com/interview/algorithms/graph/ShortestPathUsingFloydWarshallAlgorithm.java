package com.interview.algorithms.graph;

import com.example.datastructures.weighted.graph.WeightedGraph;

/**
 * 
 * 
 * @author ajitkoti
 *
 */
public class ShortestPathUsingFloydWarshallAlgorithm {

	private static WeightedGraph wgraph;

	// Solves the all-pairs shortest path problem using Floyd Warshall algorithm
	private static void floydWarshell()
	{
	    /* dist[][] will be the output matrix that will finally have the shortest 
	      distances between every pair of vertices */
	    int dist[][] = new int [wgraph.adjMat.length][ wgraph.adjMat.length];
	    int i, j, k;
	 
	    /* Initialize the solution matrix same as input graph matrix. Or 
	       we can say the initial values of shortest distances are based
	       on shortest paths considering no intermediate vertex. */
	    for (i = 0; i < wgraph.adjMat.length; i++)
	        for (j = 0; j < wgraph.adjMat.length; j++)
	            dist[i][j] = wgraph.adjMat[i][j];
	 
	    /* Add all vertices one by one to the set of intermediate vertices.
	      ---> Before start of a iteration, we have shortest distances between all
	      pairs of vertices such that the shortest distances consider only the
	      vertices in set {0, 1, 2, .. k-1} as intermediate vertices.
	      ----> After the end of a iteration, vertex no. k is added to the set of
	      intermediate vertices and the set becomes {0, 1, 2, .. k} */
	    for (k = 0; k < wgraph.adjMat.length; k++)
	    {
	        // Pick all vertices as source one by one
	        for (i = 0; i < wgraph.adjMat.length; i++)
	        {
	            // Pick all vertices as destination for the
	            // above picked source
	            for (j = 0; j < wgraph.adjMat.length; j++)
	            {
	                // If vertex k is on the shortest path from
	                // i to j, then update the value of dist[i][j]
	                if (dist[i][k] + dist[k][j] < dist[i][j])
	                    dist[i][j] = dist[i][k] + dist[k][j];
	            }
	        }
	    }
	 
	    // Print the shortest distance matrix
	    printSolution(dist);
	}
	
	/* A utility function to print solution */
	static void printSolution(int dist[][])
	{
	    System.out.println("Following matrix shows the shortest distances between every pair of vertices ");
	    for (int i = 0; i < dist.length; i++)
	    {
	        for (int j = 0; j < dist.length; j++)
	        {
	            if (dist[i][j] == Integer.MAX_VALUE)
	            	System.out.print("INF" + " ");
	            else
	            	System.out.print(dist[i][j] + " ");
	        }
	        System.out.println();;
	    }
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

		wgraph.addEdge(0, 1, Integer.MAX_VALUE); // AB Integer.MAX_VALUE
		wgraph.addEdge(0, 2, 4); // Ac 4
		wgraph.addEdge(1, 2, 3); // BC 10
		wgraph.addEdge(1, 3, Integer.MAX_VALUE); // BD Integer.MAX_VALUE
		wgraph.addEdge(1, 4, Integer.MAX_VALUE); // BE Integer.MAX_VALUE
		wgraph.addEdge(3, 2, 5); // DC 5
		wgraph.addEdge(3, 1, 1); // DB 1
		wgraph.addEdge(4, 3, -3); // ED 5

		floydWarshell();

//		return 0;
	}

}
