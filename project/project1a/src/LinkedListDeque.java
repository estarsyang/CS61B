public class LinkedListDeque<T> {


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

    private Node sentFront;
    private Node sentBack;
    private Node first;
    private int size;

    public LinkedListDeque(){
        sentFront = new Node(null, null);
        sentBack = new Node(null, null);

        sentFront.next = sentBack;
        sentBack.pre = sentFront;
        size = 0;
    }
    public LinkedListDeque(T item){
        sentFront = new Node(null,null, null);
        sentBack = new Node(null,null, null);
        first = new Node(item, sentFront,sentBack);

        sentFront.next = first;
        sentBack.pre = first;
        size = 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public void addFirst(T item){
        Node curNode = sentFront.next;
        Node newNode = new Node(item,sentFront,curNode);
        sentFront.next = newNode;
        curNode.pre = newNode;
        size++;
    }
    public void addLast(T item){
        Node curNode = sentBack.pre;
        Node newList = new Node(item,curNode,sentBack);
        curNode.next = newList;
        sentBack.pre = newList;
        size++;
    }

    public void printDeque(){
        Node curNode = sentFront.next;
        while (curNode.item != null){
            System.out.println(curNode.item + "");
            curNode = curNode.next;
        }
    }
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        Node curNode = sentFront.next;
        sentFront.next = curNode.next;
        curNode.next.pre = sentFront;
        size--;
        return curNode.item;

    }
    public T removeLast(){
        if (size ==0){
            return null;
        }
        Node curNode = sentBack.pre;
        sentFront.pre = curNode.pre;
        curNode.pre.next = sentBack;
        size--;
        return curNode.item;
    }
    public T get(int index){
        if (index > size){
            return null;
        }
        Node curNode = sentFront.next;
        for (int i=0;i>=index;i++){
            curNode = curNode.next;
        }
        return curNode.item;
    }

    public Node getRecursiveHelper(Node curNode,int index){
        if (index == 0) {
            return curNode;
        }
        curNode = getRecursiveHelper(curNode.next,index - 1);
        return curNode;
    }
    public T getRecursive(int index){
        if (index > size){
            return null;
        }
        return getRecursiveHelper(sentFront.next,index).item;
    }

    public static void main(String[] args){
        LinkedListDeque L = new LinkedListDeque(0);
        L.addLast(1);
        L.addLast(2);
        L.printDeque();
        System.out.println(L.getRecursive(2));

    }
}
