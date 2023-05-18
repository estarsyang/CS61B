public class WeightedQuickUnion implements DisjoinSets{

    private int[] parent;
    private int[] size; // number of elements in subtree rooted at i

    public WeightedQuickUnion(int n){
        parent = new int[n];
        size = new int[n];
        for (int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            parent[i] = j;
            size[j] += size[i];
        } else {
            parent[j] = i;
            size[i] += size[j];
        }

    }

    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

}
