public class SLList {

  public static class IntNode {
    public int item;
    public IntNode next;
  
    public IntNode(int i, IntNode n) {
      item = i;
      next = n;
    }
  }
  


  private IntNode first;
  private IntNode sentinel;
  private int size;

  public SLList() {
    sentinel = new IntNode(63, null);
    size = 0;
  }

  public SLList(int i) {
    sentinel = new IntNode(63, null);
    sentinel.next = new IntNode(i, null);
    size = 1;
  }

  public void addFirst(int x) {
    sentinel.next = new IntNode(x, sentinel.next);
    size += 1;
  }
  public int getFirst() {
    return sentinel.next.item;
  }

  public void addLast(int x) {
    // IntNode p = first;
    // size += 1;

    // while(p.next != null) {
    //   p = p.next;
    // }
    // p.next = new IntNode(x, null);
    size += 1;
    IntNode p = sentinel;
    
    while(p.next != null) {
      p = p.next;
    }
    p.next = new IntNode(x, null);
  }

  // private int size(IntNode p) {
  //   if(p.next == null) {
  //     return 1;
  //   }
  //   return 1 + size(p.next);

  // }
  // /** two methods with the same name but different signatures are overloaded */
  // public int size() {
  //   return size(first);
  // }
  public int size(){
    return size;
  }
}
