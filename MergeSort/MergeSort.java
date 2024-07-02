import java.util.Arrays;
import java.lang.Math;
public class MergeSort {

    public static int findNthElement(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr[(int) Math.ceil(arr.length / 2.0)-1];
    }

    private static void mergeSort(int[] arr, int minIdx, int maxIdx) {
        if (minIdx < maxIdx) {
            int mid = (minIdx + maxIdx) / 2;
            mergeSort(arr, minIdx, mid);
            mergeSort(arr, mid + 1, maxIdx);
            merge(arr, minIdx, mid, maxIdx);
        }
    }

    private static void merge(int[] arr, int minIdx, int mid, int maxIdx) {
        int n1 = mid - minIdx + 1;
        int n2 = maxIdx - mid;
        int[] L = Arrays.copyOfRange(arr, minIdx, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, maxIdx + 1);

        int i = 0, j = 0, k = minIdx;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }


}
