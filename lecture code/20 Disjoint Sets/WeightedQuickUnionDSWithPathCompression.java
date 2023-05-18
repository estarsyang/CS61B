public class WeightedQuickUnionDSWithPathCompression implements DisjoinSets{
    private int[] parent;
    private int[] size; // number of elements in subtree rooted at i

    public WeightedQuickUnionDSWithPathCompression(int n){
        parent = new int[n];
        size = new int[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
            size[i] = 1;
        }
    }


    private int find(int p){
        if (p == parent[p]){
            return p;
        } else {
            parent[p] = find(parent[p]);
            return parent[p];
        }
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


    /** Check to see if two items are connected. */
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }


    /** DISC09 */
    public static void Q1() {
        WeightedQuickUnionDSWithPathCompression wqupcDS = new WeightedQuickUnionDSWithPathCompression(16);

    }


    public static void main(String[] args) {
        int n= 8;
        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i] = i;
        }

        WeightedQuickUnionDSWithPathCompression wqupcDS = new WeightedQuickUnionDSWithPathCompression(n);
        for (int j=0;j<n - 1;j++){
            wqupcDS.connect(j,j+1);
        }
        System.out.println("he");
    }
}
