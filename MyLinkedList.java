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
    //idx doesn't actually iterate through the string, but it keeps track of where current is
    int idx = 0;
    Node current = start;
    //loops through until it reaches the end or it reaches the index
    while (current.next() != null && idx < index){
      idx ++;
    }
    //I have to modify this so it doesn't return the last element if the idx doesn't exist
    return current.data();
  }

  public Integer set(int index, Integer value){
    //save the old value to return it later
    oldVal = data.get(index);
    //set value
    data.get(x) = value;
    return oldVal;
  }

  public boolean contains(Integer value){
    Node current = start;
    //loops through until it reaches the end (or if it returns true before)
    while (current.next() != null){
      //if it reaches the value, return true
      if (current.data() = value){
        return true;
      }
      current = current.next();
    }
    //if it reaches the end of the list without finding the value, return false
    return false;
  }

  public int indexOf(Integer value){
    Node current = start;
    //idx doesn't actually iterate through the elements, it just keeps track of where current is
    int idx = 0;
    //loops through until it reaches the end (or if it returns true before)
    while (current.next() != null){
      if (current.data() = value){
        return idx;
      }
      current = current.next();
      idx ++;
    }
  }

  public void add(int index,Integer value){
    Node endAddition = (value, index, index + 1);
    index.setNext() = endAddition;
    size++;
    //fix index to make Node
  }

  public Integer remove(int index){
    //need to do border case of size zero;
    (index - 1).setNext(index + 1);
    size--;
  }
}
