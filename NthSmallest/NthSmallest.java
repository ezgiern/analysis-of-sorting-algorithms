public class NthSmallest {

    public static int nthSmallest(int[] list, int n) {
        int index = select(list, 0, list.length - 1, n - 1);
        return list[index];
    }

    public static int select(int[] list, int left, int right, int n) {
        while (true) {
            if (left == right) {
                return left;
            }
            int pivotIndex = pivot(list, left, right);
            pivotIndex = partition(list, left, right, pivotIndex, n);
            if (n == pivotIndex) {
                return n;
            } else if (n < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    public static int pivot(int[] list, int left, int right) {
        if (right - left < 5) {
            return partition5(list, left, right);
        }
        for (int i = left; i <= right; i += 5) {
            int subRight = i + 4;
            if (subRight > right) {
                subRight = right;
            }
            int median5 = partition5(list, i, subRight);
            swap(list, median5, left + (i - left) / 5);
        }
        int mid = left + (right - left) / 10;
        return select(list, left, left + (right - left) / 5, mid);
    }

    public static int partition(int[] list, int left, int right, int pivotIndex, int n) {
        int pivotValue = list[pivotIndex];
        swap(list, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (list[i] < pivotValue) {
                swap(list, storeIndex, i);
                storeIndex++;
            }
        }
        int storeIndexEq = storeIndex;
        for (int i = storeIndex; i < right; i++) {
            if (list[i] == pivotValue) {
                swap(list, storeIndexEq, i);
                storeIndexEq++;
            }
        }
        swap(list, right, storeIndexEq);
        if (n < storeIndex) {
            return storeIndex;
        }
        if (n <= storeIndexEq) {
            return n;
        }
        return storeIndexEq;
    }

    public static int partition5(int[] list, int left, int right) {
        int i = left + 1;
        while (i <= right) {
            int j = i;
            while (j > left && list[j - 1] > list[j]) {
                swap(list, j - 1, j);
                j--;
            }
            i++;
        }
        return left + (right - left) / 2;
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
