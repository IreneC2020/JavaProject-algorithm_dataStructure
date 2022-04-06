package testing;

import static modules.ModuleOne.binarySearch;
import static modules.ModuleOne.bubbleSort;
import static modules.ModuleOne.contains;
import static modules.ModuleOne.insertionSort;
import static modules.ModuleOne.indexOf;
import static modules.ModuleOne.max;
import static modules.ModuleOne.selectionSort;

public class AlgorithmsTest {

    public static void checkBinarySearch(int[] data){
        System.out.println();
        System.out.println(" ---- B I N A R Y    S E A R C H -----");
        System.out.println();
        print(data);
        System.out.println("location of 2: " + binarySearch(data, 2));
        System.out.println("location of 7: " + binarySearch(data, 7));
        System.out.println("location of 9: " + binarySearch(data, 9));
        System.out.println();
    }

    public static void checkBubbleSort(int[] data) {
        System.out.println(" ---- B U B B L E   S O R T -----");
        print(data);
        bubbleSort(data);
        System.out.println("----------------AFTER SORTING --------------");
        for(int item : data) {
            System.out.print(" " + item + " ");
        }
        System.out.println();
    }

    public static void checkContains(int[] data, int target, int number){
        System.out.println(" --------------------- CHECK CONTAINS___________");
        System.out.println("Data set: ");
        print(data);
        System.out.println("Does the array contains " + number +"? " + contains(data, target));
        System.out.println();
        System.out.println();
    }

    public static void checkIndexOf(int[] data, int target){
        System.out.println(" --------------------- CHECK INDEX OF/ LINEAR SEARCH-----------------");
        System.out.println("Data set: ");
        print(data);
        System.out.println();
        System.out.println("What is the index of " + target +"? " + indexOf(data, target));
        System.out.println();
    }

    public static void checkInsertionSort(int[] data) {
        System.out.println(" ---- I N S E R T I O N   S O R T -----");
        print(data);
        insertionSort(data);
        System.out.println("----------------AFTER SORTING --------------");
        print(data);
        System.out.println();
        System.out.println();
    }

    public static void checkMaxValue(int[] data) {
        System.out.println(" ----- M A X   V A L U E -----");
        System.out.println();
        System.out.println("Data set: ");
        print(data);
        System.out.println();
        System.out.println("Max Value of Data: " + max(data));
    }

    public static void checkSelectionSort(int[] data){
        System.out.println(" ---- S E L E C T I O N    S O R T -----");
        print(data);
        selectionSort(data);
        System.out.println("----------------AFTER SORTING --------------");
        print(data);
        System.out.println();
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" A L G O R I T H M S    T E S T    P R O G R A M ");
        System.out.println(" M O D U L E   O N E  ( ITERATIVE METHOD)");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        intro();
        int[] data  = {2, 9, 4, 1, 7, 5, 3, 8, 6};
        int[] data1 = {2, 5, 7, 1, 4, 3, 6};
        int[] data2 = {1, 2, 4, 5, 6, 8, 9};
        int[] data3 = {2, 5, 11, 1, 9, 4, 16, 8, 13};

        // searching methods
        checkIndexOf(data1, 3);
        checkIndexOf(data1, 7);
        checkIndexOf(data1, 8);
        checkBinarySearch(data2);

        // sorting methods
        checkBubbleSort(data);
        checkInsertionSort(data);
        checkSelectionSort(data);

        // other methods
        checkContains(data3, 7, 7);
        checkMaxValue(data3);
    }

    public static void print(int[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.print("[" + i + "]");
        }
        System.out.println();

        //This uses a for-each loop to print out list
        for(int item : list) {
            System.out.print(" " + item + " ");
        }
        System.out.println();
        System.out.println();
    }
}
