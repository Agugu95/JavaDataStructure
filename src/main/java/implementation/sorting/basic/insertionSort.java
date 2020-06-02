package implementation.sorting.basic;

import java.lang.String;

public class insertionSort {
    public static void simplySort(Integer[] arr, int len) {
        for (int i = 1; i < len; i++) {
            int j;
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void printArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 6, 3, 4, 1, 2};
        simplySort(arr, arr.length);
        printArr(arr);
    }
}
