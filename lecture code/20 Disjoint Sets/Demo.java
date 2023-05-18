
public class Demo {
    public static void main(String[] args) {
        QuickFindDS qfDS = new QuickFindDS(8);
        qfDS.connect(0,1);
        qfDS.connect(1,2);
        qfDS.connect(3,5);
        System.out.println(qfDS.isConnected(2,3));

        QuickUnionDS quDS = new QuickUnionDS(8);
        quDS.connect(0,1);
        quDS.connect(1,2);
        quDS.connect(3,5);
        System.out.println(quDS.isConnected(2,3));

        WeightedQuickUnion wquDS = new WeightedQuickUnion(10);
        wquDS.connect(0,1);
        wquDS.connect(1,2);
        wquDS.connect(2,3);
        wquDS.connect(3,4);
        wquDS.connect(4,5);

        wquDS.connect(6,7);
        wquDS.connect(7,8);
        wquDS.connect(8,9);

        wquDS.connect(3,8);


        System.out.println(wquDS.isConnected(2,3));
        System.out.println(wquDS.isConnected(2,1));
    }
}
