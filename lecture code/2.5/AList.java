public class AList {
  private int[] items;
  private int size;
  private int RFACTOR;

  public AList() {
    items = new int[100]; 
    size = 0;
    RFACTOR = 2; // not fix. it's flexible;
  }

  // resize the array
  public void resize(int capacity) {
    int[] a = new int[capacity];
    System.arraycopy(items, 0, a, 0,size);
    items = a;
  }

  // Insert X into the back of the list
  public void addLast(int x) {
    if(size == items.length) {
      resize(size * RFACTOR);
    }
    items[size] = x;
    size += 1;
  }
  
  // return the last of the list
  public int getLast() {
    return items[size - 1];
  }

  // get the ith item in the list
  public int getItem(int x) {
    return items[x];
  }

  // get the size of the list
  public int getSize() {
    return size;
  }

  // remove the last item of the list
  public int removeLast() {
    int x = getLast();
    size -= 1;
    return x;
  }
}