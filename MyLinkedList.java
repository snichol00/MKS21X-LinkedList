public class MyLinkedList{
  private int size;
  private Node start,end;

  //Constructor
  public MyLinkedList(int length, Node myStart, Node myEnd){
    size = length;
    start = myStart;
    end = myEnd;
  }

  public int size(){
    return size;
  }

  public boolean add(int value){
    //creates new node to set value to
    Node endAddition = new Node(value, end, null);
    end.setNext(endAddition);
    //makes sure end is updated
    end = endAddition;
    size++;
    return true;
  }

  public String toString(){
    String output = "[";
    //currentNode acts like the index, but uses next()
    Node currentNode = start;
    //when next() is null, you've reached the end
    while (currentNode.next() != null){
      output += currentNode.getData() + ",";
      //iterate the current, like doing x++
      currentNode = currentNode.next();
    }
    //won't account for last comma
    return output + "]";
  }

  private Integer get(int index){
    int idx = 0;
    Node current = start;
    while (current.next() != null && idx != index){
      idx ++;
    }
    return current.value();
  }
}
