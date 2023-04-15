/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within
 * 1. SLList implement
 * 2. access control
 * 3. nested and static class
 * 4. add more SLList functionality. addLast and size
 * 5. fast size()
 * 6. add empty list
 */
public class SLList_1 {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /** use private to replace public to prevent outside use first */
    private IntNode first;
    private int size;

    public SLList_1(int x){
        first = new IntNode(x, null);
        size = 1;
    }

    public SLList_1(){
        first = null;
        size = 0;
    }

    /** Add x to the front of the list */
    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    /** Return the first item in the list */
    public int getFirst(){
        return first.item;
    }

    /** add one IntNode to the end of SSList */
    public void addLast(int x){
        size += 1;

        if(first == null){
            first = new IntNode(x,null);
            return;
        }

        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }


    public int size() {
        return size;
    }

    public static void main(String[] args){
        /** Creates a list of one integer, namely 10 */
//        SLList_1 L =  new SLList_1(10);
//        L.addFirst(15);
//        L.addFirst(5);
//        L.addLast(20);
//
//        System.out.println(L.getFirst());
//        System.out.println(L.size());
        /** empty list test */
        SLList_1 L = new SLList_1();
        L.addLast(10);
        L.addFirst(20);
        System.out.println(L.size());
    }
}
