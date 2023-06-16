import java.util.ArrayList;

public class Graph {
    private int vertices;
    private ArrayList<Integer>[] adj;

    public Graph(int v) {
        this.vertices = v;
        adj = new ArrayList[v];
        for (int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public int size() {
        return this.vertices;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adjEdge(int v) {
        return adj[v];
    }
}
