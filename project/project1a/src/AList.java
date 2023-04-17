
/** This is a fill in the blanks version of the SLList class
 *  in case you want to try to figure out how to write it yourself.
 *  After writing your methods, you can run the AListTest file.
 */
public class AList<Item> {

    private Item[] items;
    private int size;
    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length){
            resize(items.length + 1);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1 ];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        items[size-1] = null;
        size = size-1;
        return x;
    }

    public static void main(String[] args){
//        AList a = new AList();
//        a.addLast(1);
//        System.out.println(a.getLast());
        int[] a = new int[]{0};
        int[] b = new int[]{1,2,3};
        System.out.println(a[0]);
        System.out.println(b[0]);
        System.arraycopy(a,0,b,0,a.length);
        for (int i=0;i<b.length;i++) {
            System.out.println(b[i]);
        }
    }
}