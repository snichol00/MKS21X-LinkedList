public class Node{
  private int data;
  private Node next,prev;

  public Node(int myData, Node nextNode, Node prevNode) {
    data = myData;
    next = nextNode;
    prev = prevNode;
  }

  public int getData(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  public void setData(int value){
    data = value;
  }

  public void setNext(Node nextNode){
    next = nextNode;
  }

  public void setPrev(Node prevNode){
    prev = prevNode;
  }
}
