public class Node{
  private int data;
  private Node next,prev;

  //Constructor
  public Node(int myData, Node nextNode, Node prevNode) {
    data = myData;
    next = nextNode;
    prev = prevNode;
  }

  //Accessors
  public int data(){
    return data;
  }

  public Node next(){
    return next;
  }

  public Node prev(){
    return prev;
  }

  //Mutators
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
