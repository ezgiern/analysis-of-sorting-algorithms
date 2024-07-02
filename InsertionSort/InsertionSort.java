import java.lang.Math;
import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

    }
    public static int findMiddleElement(int[] arr) {
        // Sort the array
        insertionSort(arr);
        
        return arr[(int) Math.ceil(arr.length / 2.0) - 1]; // Subtract 1 to arrange to array indexing
    }

}




