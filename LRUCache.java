class LRUCache {

  private int capacity;

  private Map<Integer,Node>  map;

  private final Node head;
  private final Node tail;

  private Node node;
 
    
  private static  class Node {
     
    int key, value;
    Node prev, next;


    public Node(int key, int value){
      this.key = key;
      this.value =value;
    }




  }




  public LRUCache(int capacity){

      this.capacity = capacity;
      this.map = new HashMap<>();
      this.tail = new Node(0,0);
      this.head= new Node(0,0);
      head.next = tail;
      tail.prev =  head;
  }


   public void addToTail(Node x){
     Node last = tail.prev;
     last.next = x; 
     x.prev = last;
     x.next = tail;
     tail.prev = x;

   }

   public void removeNode(Node x){
     x.prev.next = x.next;
     x.next.prev = x.prev;
     x.next = null;
     x.prev = null;
   }


   public void moveToTail(Node x){
     removeNode(x);
     addToTail(x);
   }
    
  public int get(int key){
    if(map.get(key) != null){
     Node node = map.get(key);
    
     moveToTail(node);
      return node.value;
    }
    return -1;
  }


  public void put(int key, int value){
    Node node = map.get(key);
    if(node != null){
      node.value = value;
      moveToTail(node);
      return;
    }

    Node fresh = new Node(key, value);
    map.put(key,fresh);
    addToTail(fresh);

    if(map.size() > capacity){
      Node oldest = head.next;
      removeNode(oldest);
      map.remove(oldest.key);
    }
  } 
}



