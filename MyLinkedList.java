public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(int length, Node myStart, Node myEnd){
    size = length;
    start = myStart;
    end = myEnd;
  }

  public int size(){
    return size;
  }

  public boolean add(int value){
    Node endAddition = new Node(value, end, null);
    end.setNext(endAddition);
    end = endAddition;
    size++;
    return true;
  }
  public String toString(){
    String output = "[";
    Node currentNode = start;
    while (currentNode.getNext() != null){
      output += currentNode.getData() + ",";
      currentNode = currentNode.getNext();
    }
    return output + "]";
  }
}
