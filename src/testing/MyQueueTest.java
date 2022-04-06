package testing;

import utility.MyQueue;
import utility.MyStack;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueueTest {

    public static void evensBeforeOdds(MyQueue<Integer> queue) {
        MyQueue<Integer> evenQueue  = new MyQueue<>();
        MyQueue<Integer> oddQueue   = new MyQueue<>();
        MyStack<Integer> stack      = new MyStack<>();
        MyStack<Integer> evenStack  = new MyStack<>();
        MyStack<Integer> oddStack   = new MyStack<>();

        queueToStack(queue, stack);

        while (!stack.isEmpty()) {
            int item = stack.pop();
            if (item % 2 == 0) {
                evenQueue.add(item);
            } else {
                oddQueue.add(item);
            }
        }
        queueToStack(evenQueue, evenStack);
        queueToStack(oddQueue, oddStack);

        while (!evenStack.isEmpty()){
            int item = evenStack.pop();
            queue.add(item);
        }
        while(!oddStack.isEmpty()){
            int item = oddStack.pop();
            queue.add(item);
        }
    }

    public static void evensBeforeOddsTest(){
        System.out.println();
        System.out.println("------------ E V E N   B E F O R E   O D D S  --------------");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(17);
        queue.add(6);
        queue.add(1);
        queue.add(8);
        queue.add(12);
        queue.add(9);
        queue.add(16);
        System.out.println("Original queue: " + queue);
        evensBeforeOdds(queue);
        System.out.println("New queue: " + queue);
        System.out.println();
        System.out.println("------------ E V E N   B E F O R E   O D D S  WITHOUT MY STACK--------------");
        MyQueue<Integer> queue1 = new MyQueue<>();
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        queue1.add(17);
        queue1.add(6);
        queue1.add(1);
        queue1.add(8);
        queue1.add(12);
        queue1.add(9);
        queue1.add(16);
        System.out.println("Original queue: " + queue1);
        evensBeforeOddsWithoutMyStack(queue1);
        System.out.println("New queue: " + queue1);
    }


    public static void evensBeforeOddsWithoutMyStack(MyQueue<Integer> queue) {
        MyQueue<Integer> evenQueue = new MyQueue<>();
        MyQueue<Integer> oddQueue  = new MyQueue<>();

        while (!queue.isEmpty()) {
            int item = queue.remove();
            if (item % 2 == 0) {
                evenQueue.add(item);
            } else {
                oddQueue.add(item);
            }
        }

        while (!evenQueue.isEmpty()){
            int item = evenQueue.remove();
            queue.add(item);
        }
        while(!oddQueue.isEmpty()){
            int item = oddQueue.remove();
            queue.add(item);
        }
    }


    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t Q U E U E    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        System.out.println();
        System.out.println("------------ L I B R A R Y   Q U E U E --------------");
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        queue.add("Red");
        queue.add("Orange");
        queue.add("Yellow");
        queue.add("Green");
        queue.add("Blue");
        queue.add("Indigo");
        queue.add("Violet");

        //test remove
        System.out.println("************Test remove/ size /isEmpty**************");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + queue.size());
        System.out.println(queue);
        System.out.println("----------1st remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println("----------2nd remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println("----------3rd remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------4th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------5th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------6th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------7th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------isEmpty() peek -----------");
        System.out.println("Remove element: " + queue.peek());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println();

        //test peek
        System.out.println("************Test peek**************");
        queue1.add("Red");
        queue1.add("Orange");
        queue1.add("Yellow");
        System.out.println(queue1);
        System.out.println(queue1.peek());
        System.out.println();

        //test add
        System.out.println("************Test add and print front and back **************");
        queue2.add("Red");
        queue2.add("Orange");
        queue2.add("Yellow");
        System.out.print("Front ");
        System.out.print(queue2);
        System.out.println("Back");
        System.out.println();
    }

    public static void myVersionTest(){
        System.out.println();
        System.out.println("------------ M Y   Q U E U E --------------");
        MyQueue<String> queue = new MyQueue<>();
        MyQueue<String> queue1 = new MyQueue<>();
        MyQueue<String> queue2 = new MyQueue<>();
        System.out.println("Before add: " + queue);
        System.out.println(queue.add("Red"));
        System.out.println(queue.add("Orange"));
        System.out.println(queue.add("Yellow"));
        System.out.println(queue.add("Green"));
        System.out.println(queue.add("Blue"));
        System.out.println(queue.add("Indigo"));
        System.out.println(queue.add("Violet"));
        System.out.println("After add: " + queue);

        //test remove
        System.out.println("************Test remove/ size /isEmpty**************");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + queue.size());
        System.out.println(queue);
        System.out.println("----------1st remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println("----------2nd remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println("----------3rd remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------4th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------5th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------6th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------7th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------isEmpty() peek -----------");
        System.out.println("Remove element: " + queue.peek());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println();

        //test peek
        System.out.println("************Test peek**************");
        queue1.add("Red");
        queue1.add("Orange");
        queue1.add("Yellow");
        System.out.println(queue1);
        System.out.println(queue1.peek());
        System.out.println();

        //test add
        System.out.println("************Test add and print front and back **************");
        queue2.add("Red");
        queue2.add("Orange");
        queue2.add("Yellow");
        System.out.print("Front ");
        System.out.print(queue2);
        System.out.println("Back");
        System.out.println();
    }

    // change queue to stack with the same order from left(bottom/front) to right(top/back)
    public static void queueToStack(MyQueue<Integer> queue, MyStack<Integer> stack){
        while(!queue.isEmpty()){
            int item = queue.remove();
            stack.push(item);
        }
    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
        evensBeforeOddsTest();
    }
}
