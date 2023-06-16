import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Undirected Graph implementation
 */
public class Graph {
    private int V;
    private ArrayList<Integer>[] adjacent;

    public Graph(int v){
        this.V = v;
        adjacent = new ArrayList[V];
        for (int i = 0;i < V; i++) {
            adjacent[i] = new ArrayList();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adjacent[v].add(w);
        adjacent[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adjacent[v];
    }
}
