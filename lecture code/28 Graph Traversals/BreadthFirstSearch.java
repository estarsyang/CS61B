import java.util.Queue;
import java.util.ArrayList;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstSearch(Graph g) {
        int size = g.size();
        marked = new boolean[size];
        edgeTo = new int[size];
    }


    public void bfs(Graph g, int s) {
        ArrayList<Integer> queue = new ArrayList<Integer>();

        queue.add(s);
        marked[s] = true;

        while(!queue.isEmpty()) {
            int v = queue.remove(0);
            System.out.print(v + " ");
            for (int w: g.adjEdge(v)){
                if (!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        BreadthFirstSearch bfsDemo = new BreadthFirstSearch(g);
        bfsDemo.bfs(g, 0);
    }
}
