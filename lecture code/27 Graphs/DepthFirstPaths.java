import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked; // market[v] is true if v connected to s;
    private int[] edgeTo; // edgeTo[v] is previous vertex on path from s to v
    private final int s;

    public DepthFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,s); // find vertices connected to s
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        Iterable<Integer> wlist = G.adj(v);
        for (int w: wlist){
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }


    /**
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     * @param  v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         {@code s} and vertex {@code v}, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        // [0,0,1,2]
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
//        g.addEdge(0, 1);
//        g.addEdge(1, 2);
//        g.addEdge(1, 4);
//        g.addEdge(2, 5);
//        g.addEdge(3, 4);
//        g.addEdge(4, 5);
//        g.addEdge(5, 6);
//        g.addEdge(5, 8);
//        g.addEdge(6, 7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);





        DepthFirstPaths dfsDemo = new DepthFirstPaths(g, 0);
        int gSize = g.V();
        for (int v = 0;v < gSize;v++) {
            if(dfsDemo.hasPathTo(v)) {
                System.out.print(dfsDemo.s + " to " + v);
                Iterable<Integer> paths = dfsDemo.pathTo(v);
                for (int x: paths){
                    if (x != dfsDemo.s) {
                        System.out.print("-" + x);
                    }
                }
            } else {
                System.out.println(0 + " to " + v + ": not connected");
            }
        }
    }
}
