public class LinkedListDeque1<T> {


    private class Node {
        private T item;
        public Node pre;
        public Node next;
        public Node(T i, Node p,Node n){
            item = i;
            pre = p;
            next = n;
        }
        public Node( Node p,Node n){
            pre = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque1(){
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        Node newList = new Node(item, sentinel,sentinel.next);
        sentinel.next = newList;
        sentinel.next.pre = newList;
        size++;
    }
    public void addLast(T item){
        Node newList = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node ptr = sentinel.next;
        while (ptr != sentinel){
            System.out.println(ptr.item + "");
            ptr = ptr.next;
        }
    }
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return  ret;

    }
    public T removeLast(){
        if (size ==0){
            return null;
        }
        T ret = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return  ret;
    }
    public T get(int index){
        if (index >= size){
            return null;
        }
        Node ptr = sentinel;
        for (int i=0;i<=index;i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public static void main(String[] args){
        LinkedListDeque1 L = new LinkedListDeque1();
//        L.addFirst(1);
        L.addLast(1);
    }
}
