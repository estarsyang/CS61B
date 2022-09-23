public class SLLTroubleMaker{



  public static void main(String[] args) {
    // SLList L = new SLList(15);
    // L.addFirst(10);
    // L.addFirst(5);
    // int x = L.getFirst();
    // System.out.println(x);
    // L.first.next.next = L.first.next;
    SLList L = new SLList();
    System.out.println(L.size());
    SLList P = new SLList(15);
    P.addFirst(10);
    P.addFirst(5);
    System.out.println(P.size());
    System.out.println(P.getFirst());
  }
}