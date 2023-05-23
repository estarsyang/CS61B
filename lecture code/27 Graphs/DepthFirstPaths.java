public class DepthFirstPaths {
    private boolean[] marked; // market[v] is true if v connected to s;
    private int[] edgeTo; // edgeTo[v] is previous vertex on path from s to v
    private int s;

    public DepthFirstPaths(Graph G, int s){
        // ...
        dfs(G,s); // find vertices connected to s
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w: G.adj(v)){
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
}
