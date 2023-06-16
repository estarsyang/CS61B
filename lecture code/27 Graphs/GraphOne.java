// Java program to print DFS
// traversal from a given
// graph
import java.io.*;
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class GraphOne {
    private int V; // No. of vertices

    // Array of lists for
    // Adjacency List Representation
    private ArrayList<Integer> adj[];
    private boolean[] visited;

    // Constructor
    public GraphOne(int v)
    {
        V = v;
        adj = new ArrayList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new ArrayList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
        adj[w].add(v); // Add w to v's list.
    }
    /*
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterable<Integer> i = adj[v];
        for (int w: i){
            if (!visited[w]) {
                DFSUtil(w, visited);
            }
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
    */
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(" vertex: " + vertex);


        for (int w: adj[vertex]) {
            if (!visited[w]) {
                DFS(w);
            }
        }
    }

    // Driver's Code
    public static void main(String args[])
    {
        GraphOne g = new GraphOne(9);

//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 3);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 0)");

        // Function call
        g.DFS(0);
    }
}
