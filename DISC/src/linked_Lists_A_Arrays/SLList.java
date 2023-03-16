package linked_Lists_A_Arrays;

public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public  IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;
    public  void  addFirst(int x) {
        first = new IntNode(x, first);
    }

    public  void  insert(int item, int position) {
        if(first == null || position == 0) {
            addFirst(item);
        }
        IntNode currentNode = first;
        while (position > 1 && currentNode.next != null) {
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }
}