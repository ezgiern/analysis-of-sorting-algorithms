public class QuickSelect1 {

    public static int findNthElement(int[] arr, int k) { //k which is calculated in Test class then we call the findNthElement
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        int pivotIndex = partition(arr, low, high);
        if (k < pivotIndex - low + 1) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else if (k == pivotIndex - low + 1) {
            return arr[pivotIndex];
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k - (pivotIndex - low + 1));
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}

