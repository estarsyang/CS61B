public class QuickFindDS implements DisjoinSets{
    private int[] id;

    public QuickFindDS(int n){
        id = new int[n];
        for (int i=0;i<n;i++){
            id[i] = i;
        }
    }

    @Override
    public void connect(int p, int q){
        // 0 1
        int pid = id[p]; // 0
        int qid = id[q]; // 1
        for (int i=0;i<id.length;i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }


}
