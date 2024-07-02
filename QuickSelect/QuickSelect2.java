public class QuickSelect2 {

    public static int findNthElement(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIdx = medianOfThree(arr, low, high);
            int partitionIndex = partition(arr, low, high, pivotIdx);
            if (k < partitionIndex - low + 1) {
                return quickSelect(arr, low, partitionIndex - 1, k);
            } else if (k == partitionIndex - low + 1) {
                return arr[partitionIndex];
            } else {
                return quickSelect(arr, partitionIndex + 1, high, k - (partitionIndex - low + 1));
            }
        }
        return -1;
    }

    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid] < arr[low]) {
            swap(arr, low, mid);
        }
        if (arr[high] < arr[low]) {
            swap(arr, low, high);
        }
        if (arr[mid] < arr[high]) {
            swap(arr, mid, high);
        }
        return high; // Return the index of the median of three pivot
    }

    private static int partition(int[] arr, int low, int high, int pivotIdx) {
        int pivotValue = arr [pivotIdx];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; // return index number of partition location
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}

