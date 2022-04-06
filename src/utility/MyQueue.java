package utility;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyQueue implements a FIFO data structure using a
 * Singly Linked List (SLL).
 *****************************************************************/

public class MyQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int     size;

    public MyQueue(){
        first = null;
        last  = null;
        size  = 0;
    }

    public boolean add(E item){
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    private void append(E item){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(item);
        last            = newNode;

        if(isEmpty())
            first = newNode;
        else
            oldLast.next = newNode;
    }

    public boolean isEmpty() {
        return first == null && size == 0;
    }

    public E peek(){
        return isEmpty() ? null : first.data;
    }

    public E remove(){
        if(isEmpty())
            throw new NoSuchElementException("Queue is Empty!");

        E firstItem         = first.data;
        Node<E> oldFirst    = first;
        first               = first.next;
        oldFirst.next       = null;
        size--;
        return firstItem;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next)
                result.append(", ").append(node.data);
            return result.append("]").toString();
        }
    }

    // Static Inner Class : Decoupled from Outer Class (Linked List)
    private static class Node<E>{
        Node<E> next;
        E       data;

        public Node(E data){
            this(null, data);
        }

        public Node(Node<E> next, E data){
            this.next = next;
            this.data = data;
        }
    }
}
