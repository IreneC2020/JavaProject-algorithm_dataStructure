package utility;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *****************************************************************/

public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int     size;

    public LinkedList(){
        first   = null;
        last    = null;
        size    = 0;
    }

    @Override
    public boolean add(E item) {
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    @Override
    public void add(int index, E item) {
        if(index == size){
            append(item);
        }else {
            checkIndex(index);
            insertBefore(index, item);
        }
        size++;
    }

    private void append(E item){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(oldLast, item);
        last            = newNode;

        if(isEmpty())
            first  = newNode;
        else
            oldLast.next  = newNode;
    }

    private void checkIndex(int index){
        String message = "Invalid Index: " + index + ", size: " + size;
        if (index < 0 || index >= size )
            throw new IndexOutOfBoundsException(message);
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    private E detach(int index){
        Node<E> current     = node(index);
        Node<E> nodeBefore  = current.prev;
        Node<E> nodeAfter   = current.next;
        E       data        = current.data;

        //detach node before from current node
        if(nodeBefore == null)
            first = nodeAfter;
        else
            nodeBefore.next = nodeAfter;

        //detach node after from current node
        if(nodeAfter == null)
            last = nodeBefore;
        else
            nodeAfter.prev = nodeBefore;

        //detach the current node for garbage collection
        current.next = null;
        current.prev = null;

        return data;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = node(index);
        return current.data;
    }


    @Override
    public int indexOf(E item) {
        int index = 0;
        for (Node<E> node = first; node != null; node = node.next) {
            if (node.data.equals(item))
                return index;
            index++;
        }
        return -1;
    }

    private void insertBefore(int index, E item){
        Node<E> current     = node(index);
        Node<E> nodeBefore  = current.prev;
        Node<E> newNode     = new Node<>(nodeBefore, current, item);
        current.prev        = newNode;

        if(nodeBefore == null)
            first = newNode;
        else
            nodeBefore.next = newNode;
    }

    @Override
    public boolean isEmpty() {
        return first == null && size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    private Node<E> node(int index){
        Node<E> current;
        if(index < size / 2) {
            current  = first;
            for (int i = 0; i < index; i++)
                current = current.next;
        }else{
            current = last;
            for (int i = size - 1; i > index ; i--)
                current = current.prev;
        }
        return current;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldItem = detach(index);
        size--;
        return oldItem;
    }

    @Override
    public boolean remove(E item) {
        if (contains(item)){
            E oldItem = remove(indexOf(item));
            return item.equals(oldItem);
        }
        return false;
    }

    @Override
    public E set(int index, E item) {
        checkIndex(index);
        Node<E> current = node(index);
        E oldItem       = current.data;
        current.data    = item;
        return oldItem;
    }

    @Override
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


    private class LinkedIterator implements Iterator<E> {
        Node<E> current;
        int     position;
        boolean isRemovable;

        public LinkedIterator(){
            current     = first;
            position    = 0;
            isRemovable = false;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            String message = "No Elements Left!";
            if(!hasNext())
                throw new NoSuchElementException(message);

            E currentItem   = current.data;
            current         = current.next;
            position++;
            isRemovable     = true;
            return currentItem;
        }

        @Override
        public void remove() {
            String message = "Unable to Remove";
            if(!isRemovable)
                throw new IllegalStateException(message);

            LinkedList.this.remove(--position);
            isRemovable = false;
        }
    }

    // Static Inner Class : Decoupled from Outer Class (Linked List)
    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E       data;

        public Node(Node<E> prev, E data){
            this(prev, null, data);
        }

        public Node(Node<E> prev, Node<E> next, E data){
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

}

