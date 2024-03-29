/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within
 * 1. SLList implement
 * 2. access control
 * 3. nested and static class
 * 4. add more SLList functionality. addLast and size
 */
public class SLList {

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

    public SLList(int x){
        first = new IntNode(x, null);
    }

    /** Add x to the front of the list */
    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    /** Return the first item in the list */
    public int getFirst(){
        return first.item;
    }

    /** add one IntNode to the end of SSList */
    public void addLast(int x){
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list that start at IntNode p */
    private int size(IntNode p){
        if(p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size(first);
    }

    public static void main(String[] args){
        /** Creates a list of one integer, namely 10 */
        SLList L =  new SLList(10);
        L.addFirst(15);
        L.addFirst(5);
        L.addLast(20);

        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
