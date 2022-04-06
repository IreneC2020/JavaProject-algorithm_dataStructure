package testing;

public class LinkedNodesTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t L I N K E D    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void testNode(){
        // Tom, Ben, Sam, John, Tim
        Node<String> first          = new Node<>("Tom");
        first.next                  = new Node<>("Ben");
        first.next.next             = new Node<>("Sam");
        first.next.next.next        = new Node<>("John");
        first.next.next.next.next   = new Node<>("Tim");

        System.out.println(print(first));
    }

    public static void main(String[] args) {
        intro();
        testNode();
    }

    public static String print(Node<String> first){
        if(first == null){
            return "[]";
        }else{
            StringBuilder builder = new StringBuilder("[" + first.data);
            for (Node<String> node = first.next; node != null; node = node.next){
                builder.append(", ").append(node.data);
            }
            return  builder.append("]").toString();
        }
    }


    public static class Node<E>{
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
