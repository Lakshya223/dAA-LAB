// Java program to print DFS
//mtraversal from a given given
// graph
import java.io.*;
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Main {
	private int V; 
	boolean visited[];// No. of vertices

	// Array of lists for
	// Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	 Main(int v)
	{
		V = v;
		adj = new LinkedList[v];
		visited=new boolean[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v's list.
	}

	// A function used by DFS
	void DFSUtil(int v)
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this
		// vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n);
		}
	}

	// The function to do DFS traversal.
	// It uses recursive
	// DFSUtil()
	

	// Driver Code
	public static void main(String args[])
	{
		Main G = new Main(10);

G.addEdge(0, 1);
G.addEdge(0,8);
G.addEdge(8,2);
G.addEdge(8,6);
G.addEdge(6,5);
G.addEdge(6,7);
G.addEdge(2,5);
G.addEdge(2,4 );
G.addEdge(2,3);
G.addEdge(4,7);

		System.out.println(
			"Following is Depth First Traversal "
			+ "(starting from vertex 2)");

		G.DFSUtil(0);
	}
}
// This code is contributed by Aakash Hasija
