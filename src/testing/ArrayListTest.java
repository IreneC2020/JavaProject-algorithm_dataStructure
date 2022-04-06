package testing;

import utility.ArrayList;
import utility.List;
import utility.Iterator;

public class ArrayListTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t \t M Y   A R R A Y   L I S T ");
        System.out.println(" \t \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        System.out.println();
        System.out.println(" \t  L I B R A R Y    A P I ");
        java.util.List<String> list = new java.util.ArrayList<>();

        // add(item) check
        System.out.println(" \t =========== T E S T   A D D =========== ");
        list.add("Tom");
        System.out.println(list);
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        list.add(0, "Tim");
        System.out.println(list);
        list.add("Will");
        System.out.println(list);
        System.out.println();
        System.out.println(" \t =========== T E S T   SIZE & ISEMPTY =========== ");
        // isEmpty() test
        System.out.println("Is the array empty? " + list.isEmpty());
        System.out.println();

        // size() test
        System.out.println(list);
        System.out.println("list size: " + list.size());
        System.out.println();
        //test remove
        System.out.println(" \t =========== T E S T   R E M O V E =========== ");
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 1: " + list.remove(1));
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 4: " + list.remove(4));
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println();

        //test clear
        System.out.println(" \t =========== T E S T   C L E A R =========== ");
        list.clear();
        System.out.println(list);

        //test contains
        System.out.println(" \t =========== T E S T   CONTAINS =========== ");
        list.add("Tom");
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        System.out.println("Does the list contain 'Will'? " + list.contains("Will"));
        System.out.println();

        // test get index
        System.out.println(" \t =========== T E S T   GET INDEX =========== ");
        System.out.println(list);
        System.out.println("What is in index 2" + list.get(2));
        System.out.println();

        // test indexOf
        System.out.println(" \t =========== T E S T   INDEX OF =========== ");
        System.out.println(list);
        System.out.println("What is the index of John" + list.indexOf("John"));
        System.out.println();

        // remove(index) test
        System.out.println(" ==TEST R E M O V E  T E S T  ( I N D E X ) == ");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println();

        // test remove(item)
        System.out.println(" == TEST R E M O V E  T E S T  ( I T E M ) == ");
        System.out.println(list);
        System.out.println("Can I remove John?" + list.remove("John"));
        System.out.println();

        //set(index, item) test
        System.out.println(" == TEST SET (INDEX, ITEM)== ");
        System.out.println(list);
        list.set(1, "Mary");
        System.out.println(list);
        System.out.println();

        // Iterator test
        System.out.println("== I T E R A T O R    T E S T ==");
        java.util.Iterator<String> itr = list.iterator();
        System.out.println(list);

        while (itr.hasNext())
            System.out.println(itr.next());

        System.out.println();

    }

    public static void myVersionTest(){
        System.out.println();
        System.out.println(" \t  M Y   A P I ");
        List<String> list = new ArrayList<>();

        // add(item) check
        System.out.println(" \t =========== T E S T   A D D =========== ");
        list.add("Tom");
        System.out.println(list);
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        list.add(0, "Tim");
        System.out.println(list);
        list.add("Will");
        System.out.println(list);
        System.out.println();
        System.out.println(" \t =========== T E S T   SIZE & ISEMPTY =========== ");
        // isEmpty() test
        System.out.println("Is the array empty? " + list.isEmpty());
        System.out.println();

        // size() test
        System.out.println(list);
        System.out.println("list size: " + list.size());
        System.out.println();
        //test remove
        System.out.println(" \t =========== T E S T   R E M O V E =========== ");
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 1: " + list.remove(1));
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println("Item Removed From Index 4: " + list.remove(4));
        System.out.println("Size: " + list.size());
        System.out.println(list);
        System.out.println();

        //test clear
        System.out.println(" \t =========== T E S T   C L E A R =========== ");
        list.clear();
        System.out.println(list);

        //test contains
        System.out.println(" \t =========== T E S T   CONTAINS =========== ");
        list.add("Tom");
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        System.out.println(list);
        System.out.println("Does the list contain 'Will'? " + list.contains("Will"));
        System.out.println();

        // test get index
        System.out.println(" \t =========== T E S T   GET INDEX =========== ");
        System.out.println(list);
        System.out.println("What is in index 2? " + list.get(2));
        System.out.println();

        // test indexOf
        System.out.println(" \t =========== T E S T   INDEX OF =========== ");
        System.out.println(list);
        System.out.println("What is the index of John? " + list.indexOf("John"));
        System.out.println();

        // remove(index) test
        System.out.println(" ==TEST R E M O V E  T E S T  ( I N D E X ) == ");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println();

        // test remove(item)
        System.out.println(" == TEST R E M O V E  T E S T  ( I T E M ) == ");
        System.out.println(list);
        System.out.println("Can I remove John?" + list.remove("John"));
        System.out.println();

        //set(index, item) test
        System.out.println(" == TEST SET (INDEX, ITEM)== ");
        System.out.println(list);
        list.set(1, "Mary");
        System.out.println(list);
        System.out.println();

        // Iterator test
        System.out.println("== I T E R A T O R    T E S T ==");
        Iterator<String> itr = list.iterator();
        System.out.println(list);

        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
    }
}
