import java.util.Iterator;

/**
 * Graph
 * A set of nodes connected pairwise by edges
 * Type
 *              Directed    Undirected
 * - Acyclic
 * - Cyclic
 *
 */

public class GraphRepresent {
    /**
     * Graph API
     */
    public class Graph{
        public Graph(int V){ // Create an empty graph with V vertices

        }
        public void addEdge(int v, int w){ // add an edge v-w

        }
        Iterator<Integer> adj(int v){ // vertices adjacent to v

        }
        int V(){ // number of vertices

        }
        int E(){ // number of edges

        }

        /** degree of vertex v in graph G. */
        public static int degree(Graph G, int v){
            int degree = 0;
            for (int w: G.adj(v)) {
                degree++;
            }
            return degree;
        }
    }
}
