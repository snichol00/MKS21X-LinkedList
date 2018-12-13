public class Node{
  private int data;
  private Node next,prev;

  public Node(int myData, Node nextNode, Node prevNode){
    data = myData;
    next = nextNode;
    prev = prevNode;
  }
}
