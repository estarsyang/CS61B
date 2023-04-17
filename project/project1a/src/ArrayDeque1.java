public class ArrayDeque1<T> {

    private T[] items;
    private int  size;

    public ArrayDeque1() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }


    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void addFirst(T item){
        if (size == items.length){
            resize(items.length + 1);
        }
        T[] a =(T[]) new Object[size + 1];
        a[0] = item;
        System.arraycopy(items,0,a,1,size);
        items = a;
        size++;
    }
    public void addLast(T item){
        if (size == items.length){
            resize(items.length + 1);
        }
        items[size] = item;
        size++;
    }
    public void printDeque(){
        for (int i=0;i<size;i++){
            System.out.println(get(i));
        }
    }
    public T getLast() {
        return items[size - 1 ];
    }
    public T removeFirst(){
        T x = get(0);
        T[] a = (T[]) new Object[items.length - 1];
        System.arraycopy(items,1,a,0,items.length-1);
        items =a;
        size--;
        return x;
    }
    public T removeLast(){
        T x = getLast();
        items[size - 1] = null;
        size--;
        return x;
    }
    public T get(int index){
        if (index > size){
            return null;
        }
        return items[index];
    }

    public static void main(String[] args){
        ArrayDeque1 a = new ArrayDeque1();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addFirst(0);
        a.printDeque();
        a.removeFirst();
        a.printDeque();
    }
}

