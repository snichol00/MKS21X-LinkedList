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
    if (size == 0){
      Node only = new Node(value, null, null);
      end = only;
      start = only;
      size++;
      return true;
    }
    else{
      //creates new node to set value to
      Node endAddition = new Node(value, end, null);
      end.setNext(endAddition);
      //makes sure end is updated
      end = endAddition;
      size++;
      return true;
    }
  }

  public String toString(){
    String output = "[";
    //currentNode acts like the index, but uses next()
    Node currentNode = start;
    //when next() is null, you've reached the end
    while (currentNode.next() != null){
      output += currentNode.data() + ",";
      //iterate the current, like doing x++
      currentNode = currentNode.next();
    }
    //won't account for last comma
    return output + "]";
  }

  public Integer get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
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

  private Node getNode(int MyNode){
    if (MyNode < 0 || MyNode >= size){
      throw new IndexOutOfBoundsException();
    }
    //idx doesn't actually iterate through the string, but it keeps track of where current is
    int idx = 0;
    Node current = start;
    //loops through until it reaches the end or it reaches the index
    while (current.next() != null){
      if (idx == MyNode){
        return current;
      }
      current =  current.next();
      idx++;
    }
    return current;
  }

  public Integer set(int index, Integer value){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    //save the old value to return it later
    Node oldVal = this.getNode(index);
    Integer oldData = oldVal.data();
    //set value
    oldVal.setData(value);
    return oldData;
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
    return -1;
  }

  public void add(int index,Integer value){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    if (index = 0){
      Node addition = new Node(value, null, this.getNode(index));
      this.get(index).setPrev(addition)
      start = addition;
      size++;
    }
    if (index = size){
      Node addition = new Node(value, this.getNode(index-1), null);
      this.getNode(index-1).setNext(addition);
      end = addition;
      size++;
    }
    else{
      Node addition = new Node(value, this.getNode(index-1), this.getNode(index));
      this.getNode(index-1).setNext(addition);
      this.getNode(index).setPrev(addition);
      size++;
      //fix index to make Node
    }
  }

  public Integer remove(int index){
    //need to do border case of size zero;
    index.prev().setNext() = index.next();
    size--;
  }

  public boolean remove(Integer value){
    current = start;
    while (current.next() != null){
      if (current.getData().equals(value)){
        current.prev().setNext() = current.next();
        size--;
        return true;
      }
    }
    return false;
  }
}
