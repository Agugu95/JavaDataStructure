package implementation.sorting.basic;

public class bubbleSort {

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void simplySort(Integer[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void recursionSort(Integer[] a, int len) {
        if (len <= 1) {
            return;
        }

        boolean swapped = false;

        for (int i = 1; i < len; i++) {
            if (a[i - 1] > a[i]) {
                swap(a, i, i - 1);
                swapped = true;
            }
        }

        if (swapped) {
            recursionSort(a, len - 1);
        }
    }

    public static void countBubble(Integer[] arr, int len) {
        int k = 0;
        while (k < len - 1) {
            int last = len - 1;
            for (int j = len - 1; j > k; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 4, 3, 7, 1, 9, 8, 5};
        simplySort(arr);
        recursionSort(arr, arr.length);
        countBubble(arr, arr.length);
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
