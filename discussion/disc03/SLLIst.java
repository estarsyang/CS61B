public class SLLIst {
  private class IntNode {
    public int item;
    public IntNode next;
    public IntNode(int item, IntNode next) {
      this.item = item;
      this.next = next;
    }

    private IntNode first;

    public void addFirst(int x){
      first = new IntNode(x, first)
    }
  }
  /** Implement SLList.insert which takes in an integer x and inserts it at the given position. If the position is after the end of the list, insert the new node at the end. For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2. */ 
  public void insert(int item, int position) {
    if (first == null || position == 0) {
      addFirst(item);
      return;
    }
    IntNode currNode = first;
    while(position > 1 && currNode.next != null) {
      position--;
      currNode = currNode.next;
    }
    IntNode newNode =  new IntNode(item, currNode.next);
    currNode.next = newNode;

  }
  /** Add another method to the SLList class that reverses the elements. Do this using the existing IntNodes (you should not use new).
   * Extra: If you wrote reverse iteratively, write a second version that uses recursion (you may need a helper method). If you wrote it recursively, write it iteratively */ 
  public void reverse() {

  }
}
