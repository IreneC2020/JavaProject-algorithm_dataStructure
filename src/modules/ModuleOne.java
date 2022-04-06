package modules;

/***************************************************************
 * Update the methods with iterative versions discussed in
 * this class.
 * NOTE: Methods CANNOT use any special methods from Java API.
 ***************************************************************/

public class ModuleOne {

    public static int binarySearch(int[] data, int target) {
        int min = 0;
        int max = data.length - 1;
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;
            if( data[mid] == target )
                return mid;
            else if( data[mid] < target )
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }

    public static  void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for(int j = 1; j < data.length - i; j++) {
                if( data[j] < data[j - 1] ) {
                    swap(data, j, j - 1);
                }
            }
        }
    }

    public static boolean contains(int[] data, int target) {
        return indexOf(data, target) != -1;
    }

    public static int indexOf(int[] data, int target) {
        for (int i = 0; i < data.length; i++)    // a - b < 0, a - b = 0, a - b > 0
            if (data[i] == target)
                return i;
        return -1;          // ITEM NOT FOUND
    }

    public static void insertionSort(int[] data) {
        int current;
        int j;
        for(int i = 1; i < data.length; i++) {
            current = data[i];
            for( j = i;
                 j > 0 && current < data[j-1]; j-- ){
                data[j] = data[j - 1];
            }
            data[j] = current;
        }
    }

    public static int max(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++)
            if (max < data[i])
                max = data[i];
        return max;
    }


    public static void selectionSort(int[] data) {
        int minIndex;
        for (int i = 0; i < data.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex] ) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(data, minIndex, i);
            }
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp    = data[a];
        data[a]     = data[b];
        data[b]     = temp;
    }
}
