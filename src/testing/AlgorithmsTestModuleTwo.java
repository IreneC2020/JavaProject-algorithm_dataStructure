package testing;

import static modules.ModuleTwo.binarySearch;
import static modules.ModuleTwo.mergeSort;
import static modules.ModuleTwo.quickSort;
import static modules.ModuleTwo.selectionSort;

public class AlgorithmsTestModuleTwo {

    public static void checkMergeSort(int[] data) {
        System.out.println(" ---- M E R G E    S O R T -----");
        print(data);
        System.out.println(" ---- After sorting -----");
        mergeSort(data);
        print(data);
        System.out.println();
        System.out.println();
    }

    public static void checkQuickSort(int[] data) {
        System.out.println(" ---- Q U I C K    S O R T -----");
        print(data);
        System.out.println(" ---- After sorting -----");
        quickSort(data);
        print(data);
        System.out.println();
        System.out.println();
    }

    public static void checkRecursiveBinarySearch(int[] data){
        System.out.println();
        System.out.println(" ---- R E C U R S I V E   B I N A R Y   S E A R C H -----");
        System.out.println();
        System.out.print("Data: ");
        print(data);
        System.out.println();
        System.out.println("location of 2: " + binarySearch(data, 2));
        System.out.println("location of 7: " + binarySearch(data, 7));
        System.out.println("location of 9: " + binarySearch(data, 9));
        System.out.println();
    }

    public static void checkRecursiveSelectionSort(int[] data){
        System.out.println(" ---- S E L E C T I O N    S O R T (RECURSIVE)-----");
        print(data);
        System.out.println();
        System.out.println(" ---- After sorting -----");
        selectionSort(data);
        print(data);
        System.out.println();
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
        System.out.println(" A L G O R I T H M S    T E S T    P R O G R A M");
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

        //searching methods
        checkRecursiveBinarySearch(data2);

        //sorting methods
        checkQuickSort(data3);
        checkMergeSort(data3);
        checkRecursiveSelectionSort(data);
        checkRecursiveSelectionSort(data1);
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
