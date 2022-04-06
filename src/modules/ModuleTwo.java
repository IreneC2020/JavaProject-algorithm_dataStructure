package modules;

import static modules.ModuleOne.swap;
/****************************************************************
 * Update the methods with the recursive versions
 * discussed in this class.
 * NOTE : Methods CANNOT use any special methods from Java API.
 ****************************************************************/

public class ModuleTwo {

    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int target, int min, int max) {
        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (data[mid] < target) {
                return binarySearch(data, target, mid + 1, max);
            } else if (data[mid] > target) {
                return binarySearch(data, target, min, mid - 1);
            } else {
                return mid;
            }
        }
    }


    private static int[] makeFirstHalf(int[] data) {
        int size        = data.length / 2;
        int[] firstHalf = new int[size];

        for (int i = 0; i < size; i++) {
            firstHalf[i] = data[i];
        }
        return firstHalf;
    }

    private static int[] makeSecondHalf(int[] data) {
        int halfSize        = data.length / 2;
        int size            = data.length - halfSize;
        int[]  secondHalf   = new int[size];
        for(int i = 0; i < size; i++){
            secondHalf[i] = data[halfSize + i];
        }
        return secondHalf;
    }

    private static void merge(int[] data, int[] left, int[] right) {
        int index      = 0;   // index of data array
        int leftIndex  = 0;   // index in left array
        int rightIndex = 0;   // index in right array

        while(leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex] < right[rightIndex])
                data[index++] = left[leftIndex++];
            else
                data[index++] = right[rightIndex++];
        }
        while(leftIndex < left.length){
            data[index++] = left[leftIndex++];
        }
        while(rightIndex < right.length){
            data[index++] = right[rightIndex++];
        }

    }

    public static void mergeSort(int[] data) {
        // split array into halves(make methods here)
        // recursive case
        if(data.length > 1){
            int[] firstHalf  = makeFirstHalf(data);
            int[] secondHalf = makeSecondHalf(data);

            // sort the two halves
            mergeSort(firstHalf);
            mergeSort(secondHalf);

            // merge the sorted halves into a sorted whole
            merge(data, firstHalf, secondHalf);
        }
        //Base Case: data.length = 0, Do nothing

    }

    private static int partition(int[] data, int low, int high) {
        int midpoint = (low + high) / 2;
        int pivot = data[midpoint];
        boolean done = false;
        while (!done) {
            while (data[low] < pivot) {
                ++low;
            }
            while (pivot < data[high]) {
                --high;
            }
            if (low >= high) {
                done = true;
            } else {
                swap(data, low, high);
                ++low;
                --high;
            }
        }
        return high;

    }

    public static void quickSort(int[] data) {
           quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] data, int min, int max) {
         int mid;
        // Base case: If there are 1 or zero entries to sort,
        // partition is already sorted

        if (min >= max) {
            return;
        }    //do nothing

        mid = partition(data, min, max);
        quickSort(data, min, mid);
        quickSort(data, mid + 1, max);
    }

    public static void selectionSort(int[] data) {
       selectionSort(data, 0);
    }

    private static void selectionSort(int[] data, int start) {
        if (start < data.length - 1) {
            int minIndex = start;        // current lowest index
            for (int i = start + 1; i < data.length; i++) {
                if (data[i] < data[minIndex]) {
                    minIndex = i;
                }
            }
            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }
}
