public class MyLinkedList{
  private int size;
  private Node start,end;

  //Constructor
  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
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
    if (size == 0){
      return "[]";
    }
    String output = "[";
    //currentNode acts like the index, but uses next()
    Node current = start;
    //when next() is null, you've reached the end
    while (current.next() != null){
      output += current.data() + ", ";
      //iterate the current, like doing x++
      current = current.next();
    }
    //won't account for last comma
    return output + end.data() + "]";
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
      if (current.data() == value){
        return true;
      }
      current = current.next();
    }
    if (end.data() == value){
      return true;
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
      if (current.data() == value){
        return idx;
      }
      current = current.next();
      idx ++;
    }
    if (end.data() == value){
      return idx;
    }
    return -1;
  }

  public void add(int index,Integer value){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      Node addition = new Node(value, null, this.getNode(index));
      getNode(index).setPrev(addition);
      start = addition;
      size++;
    }
    else if (index == size){
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
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException();
    }
    Integer oldData;
    if (size == 0 || size == 1){
      start = null;
      end = null;
      size = 0;
      oldData = null;
    }
    else if (index == 0){
      oldData = start.data();
      start = getNode(index + 1);
      start.setPrev(null);
      size --;
    }
    else if (index == size - 1){
      oldData = end.data();
      end = getNode(index - 1);
      end.setNext(null);
      size --;
    }
    else{
      oldData = getNode(index).data();
      getNode(index-1).setNext(getNode(index+1));
      getNode(index+1).setPrev(getNode(index-1));
      size--;
    }
    return oldData;
  }

  public boolean remove(Integer value){
    if (this.contains(value)){
      this.remove(indexOf(value));
      return true;
    }
    return false;
  }

  public void extend(MyLinkedList other){
        //in O(1) runtime, move the elements from other onto the end of this
        this.end.setNext(other.start);
        other.start.setPrev(this.end);
        this.end = other.end;
        //The size of this is now the combined sizes of both original lists
        this.size += other.size;
        //The size of other is reduced to 0
        other.size = 0;
    }
}
