import java.util.ArrayList;
import java.util.Arrays;
 
import java.util.List; class Main{
static class Graph
{
int v;
int e;
int[][] adj;

Graph(int v, int e)
{
this.v = v;
this.e = e;

adj = new int[v][v];
for(int row = 0; row < v; row++) 
Arrays.fill(adj[row], 0);
}
 
void addEdge(int start, int e)
{

// Considering a bidirectional edge 
adj[start][e] = 1;
adj[e][start] = 1;
}

// Function to perform BFS on the graph 
void BFS(int start)
{

// Visited vector to so that
// a vertex is not visited more than once
// Initializing the vector to false as no
// vertex is visited at the beginning
boolean[] visited = new boolean[v];
Arrays.fill(visited, false);
List<Integer> q = new ArrayList<>();
q.add(start);
 
// Set source as visited 
visited[start] = true;

int vis;
while (!q.isEmpty())
{
vis = q.get(0);

// Print the current node 
System.out.print(vis + " "); q.remove(q.get(0));

// For every adjacent vertex to
// the current vertex 
for(int i = 0; i < v; i++)
{
if (adj[vis][i] == 1 && (!visited[i]))
{

// Push the adjacent node to
// the queue 
q.add(i);

// Set
visited[i] = true;
}
}
}
}
}

// Driver code
public static void main(String[] args)
{

int v = 9, e = 10;

// Create the graph
Graph G = new Graph(v, e); G.addEdge(0, 1);
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

G.BFS(0);
}
}
