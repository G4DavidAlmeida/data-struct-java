package app;

/*
    head            tail
    |                |
    v                v
    1 <--> 5 -> 8 -> 2

     @Override
    public String toString() {
      return data.toString();
    }
    
*/

public class LinkedList<T> implements Iterable<T> {
    private int size = 0;           // access list size
    private Node<T> head = null;    // beginning of List
    private Node<T> tail = null;    // Ending of List

    private static class Node<T> {  // Method create LinkedList
        private T data;
        private Node<T> prev, next; // Atributs of position of Node and next Node

        public Node(T data, Node<T> prev, Node<T> next) { // Method Construct
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /*
            temp    temp
    head -> node -> node -> null <- tail

    */

    public void clear () {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size(){ return size; }

    public boolean isEmpty(){ return size() == 0; }

    // Add an element to the tail of the linked list, O(1)
    public void add(T elem){ addLast(elem); }
    
    public void addLast(T elem){
        if(isEmpty()) head = tail = new Node<T>(elem, null, null);
        else{
            // null <-> head(1) <-> tail(1) <-> null

            tail.next = new Node<T>(elem, tail, null);
            // null <-> head(1) <-> tail(1) <-> 2
            
            tail = tail.next;
            // null <-> head(1) <-> 1 <-> tail(2) <-> null
        }
        size++;
    }

    public void addFirst (T elem) {
        if (isEmpty()) head = tail = new Node<T>(elem, null, null);
        else {
            head.prev = new Node<T>(elem, null, null);
            head = head.prev;
        }
        size++;
    }

    public T peekFirts () {
        if (this.isEmpty()) throw new RuntimeException("Empty list");
        return this.head.data;
    }

    public T peekLast () {
        if (this.isEmpty()) throw new RuntimeException("Empty list");
        return this.tail.data;
    }

    public T removeFirst () {
        if (this.isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;
        head.data = null;
        head = head.next;
        size--;

        if (isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast(){
        if(this.isEmpty()) throw new RuntimeException("Empty list");
        
        T data = tail.data;
        tail.data = null;
        tail = tail.prev;
        size--;

        if(isEmpty()) tail = null;
        else tail.next = null;
        
        return data;
    }

    public T remove (T elem) {
        if(this.isEmpty()) throw new RuntimeException("empty list");

        Node<T> trav = head;

        if(head.data == elem) return removeFirst();
        if(tail.data == elem) return removeLast();

        while(trav.data != elem) {
            if (trav.next == null) return null;
            trav = trav.next;
        }

        T data = trav.data;
        trav.prev = trav.next; trav.next = trav.prev;
        trav.data = null;
        size--;

        return data;

        /*

        param = node3
                                              true
                                              temp
        null <-> head <-> node1 <-> node2 <-> node3 <-> tail <-> null

        null <-> head <-> node1 <-> node2 <-> node3 <-> tail <-> null

        null <-> head <-> node1 <-> node2 <-> node3 <-> tail <-> null
        */

    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
        private Node<T> trav = head;

        @Override
        public boolean hasNext() { return trav != null; }

        @Override
        public T next() {
            T data = trav.data;
            trav = trav.next;
            return data;
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }
        };
    }
}