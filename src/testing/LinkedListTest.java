package testing;

import utility.Iterator;
import utility.List;
import utility.LinkedList;

public class LinkedListTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t M Y   L I N K E D   L I S T ");
        System.out.println(" \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        System.out.println();
        System.out.println(" \t  L I B R A R Y    A P I ");
        java.util.List<String> list = new java.util.LinkedList<>();

        // size() test
        System.out.println(" \t =========== T E S T   SIZE =========== ");
        System.out.println(list);
        System.out.println("list size: " + list.size());
        System.out.println();

        System.out.println(" \t =========== T E S T   A D D =========== ");
        // add(item) test
        list.add("Tom");
        System.out.println(list);
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        list.add("Tim");
        list.add("Will");
        list.add("John");
        list.add("Bob");
        list.add("Matt");
        list.add("Jim");
        System.out.println(list);
        System.out.println();

        System.out.println(" \t =========== T E S T   A D D (INDEX, ITEM)=========== ");
        list.add(3, "Mary");
        System.out.println(list);
        System.out.println();

        // test contains
        System.out.println(" \t =========== T E S T   CONTAINS=========== ");
        System.out.println(list);
        System.out.println("Does the list contain Bob?" + list.contains("Bob"));
        System.out.println();

        // test get(index)
        System.out.println(" \t =========== T E S T   GET(INDEX)=========== ");
        System.out.println(list);
        System.out.println("What is in index 0?" + list.get(0));
        System.out.println();

//        test indexOf
        System.out.println(" \t =========== T E S T   INDEX OF=========== ");
        System.out.println(list);
        System.out.println("What is the index of Tim?" + list.indexOf("Tim"));
        System.out.println();

        // test iterator
        System.out.println("== I T E R A T O R    T E S T ==");
        java.util.Iterator<String> itr = list.iterator();
        System.out.println(list);

        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println();

        //test remove
        System.out.println(" \t =========== T E S T   R E M O V E =========== ");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 1: " + list.remove(1));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 4: " + list.remove(4));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("Can I remove Mary? " + list.remove("Mary"));
        System.out.println();

        // test set
        System.out.println(" \t =========== T E S T   SET=========== ");
        System.out.println(list);
        list.set(3, "Amy");
        System.out.println("What is the index of Tim?" + list.indexOf("Tim"));
        System.out.println();

        // test clear
        System.out.println(" \t =========== T E S T   CLEAR=========== ");
        System.out.println(list);
        list.clear();
        System.out.println(list);

        // isEmpty() test
        System.out.println(" \t =========== T E S T   EMPTY =========== ");
        System.out.println("Is the array empty? " + list.isEmpty());
        System.out.println();

    }

    public static void myVersionTest() {
        System.out.println();
        System.out.println(" \t  M Y   A P I ");
        List<String> list = new LinkedList<>();

        // isEmpty() test
        System.out.println(" \t =========== T E S T   EMPTY =========== ");
        System.out.println("Is the array empty? " + list.isEmpty());
        System.out.println();

        // size() test
        System.out.println(" \t =========== T E S T   SIZE =========== ");
        System.out.println(list);
        System.out.println("list size: " + list.size());
        System.out.println();

        System.out.println(" \t =========== T E S T   A D D =========== ");
        // add(item) test
        list.add("Tom");
        System.out.println(list);
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        list.add("Tim");
        list.add("Will");
        list.add("John");
        list.add("Bob");
        list.add("Matt");
        list.add("Jim");
        System.out.println(list);
        System.out.println();

        System.out.println(" \t =========== T E S T   A D D (INDEX, ITEM)=========== ");
        list.add(3, "Mary");
        System.out.println(list);
        System.out.println();

        // test contains
        System.out.println(" \t =========== T E S T   CONTAINS=========== ");
        System.out.println(list);
        System.out.println("Does the list contain Bob?" + list.contains("Bob"));
        System.out.println();

        // test get(index)
        System.out.println(" \t =========== T E S T   GET(INDEX)=========== ");
        System.out.println(list);
        System.out.println("What is in index 0?" + list.get(0));
        System.out.println();

//        test indexOf
        System.out.println(" \t =========== T E S T   INDEX OF=========== ");
        System.out.println(list);
        System.out.println("What is the index of Tim?" + list.indexOf("Tim"));
        System.out.println();

        // test iterator
        System.out.println("=========== I T E R A T O R    T E S T ========");
        Iterator<String> itr = list.iterator();
        System.out.println(list);

        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println();

        //test remove
        System.out.println(" \t =========== T E S T   R E M O V E =========== ");
        System.out.println("list size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 1: " + list.remove(1));
        System.out.println("list size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 4: " + list.remove(4));
        System.out.println("list size: " + list.size());
        System.out.println(list);
        System.out.println("Can I remove Mary? " + list.remove("Mary"));
        System.out.println();

        // test set
        System.out.println(" \t =========== T E S T   SET=========== ");
        System.out.println(list);
        list.set(3, "Amy");
        System.out.print("after set amy at index 3: ");
        System.out.println(list);


        // test clear
        System.out.println(" \t =========== T E S T   CLEAR=========== ");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
    }
}
