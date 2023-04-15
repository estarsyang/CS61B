/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within
 * 1. SLList implement
 * 2. access control
 * 3. nested and static class
 * 4. add more SLList functionality. addLast and size
 * 5. fast size()
 * 6. add empty list
 * 7. sentinel Nodes
 * 8. invariants
 */
public class SLList_2 {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /** use private to replace public to prevent outside use first */
    /** the first item(if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    public SLList_2(int x){
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList_2(){
        sentinel = new IntNode(63,null);
        size = 0;
    }

    /** Add x to the front of the list */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Return the first item in the list */
    public int getFirst(){
        return sentinel.next.item;
    }

    /** add one IntNode to the end of SSList */
    public void addLast(int x){
        size += 1;

        IntNode p = sentinel;
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
//        SLList_2 L =  new SLList_2(10);
//        L.addFirst(15);
//        L.addFirst(5);
//        L.addLast(20);
//
//        System.out.println(L.getFirst());
//        System.out.println(L.size());
        /** empty list test */
        SLList_2 L = new SLList_2();
        L.addLast(20);
        System.out.println(L.size());
    }
}
