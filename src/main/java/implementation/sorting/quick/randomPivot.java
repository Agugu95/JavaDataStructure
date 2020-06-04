package implementation.sorting.quick;

import java.util.Arrays;
import java.util.Random;

public class randomPivot {
    public static void quickSort(Integer[] arr, int left, int right) {
        // 재귀를 멈출 조건
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(Integer[] arr, int left, int right) {
        int pivot = getRandom(right - left) + left;
        System.out.println("pivot = " + pivot);
        int i = left;
        int j = right;
        swap(arr, left, pivot);
        System.out.println("arr = " + Arrays.deepToString(arr) + ", left = " + left + ", right = " + right);
        while (i < j) {
            while (arr[left] > arr[i]) { // pivot >= data
                i++;
            }
            while (arr[left] <= arr[j] && i < j) { // pivot <= data, outOfIndex
                j--;
            }
            if (i < j) { // swap
                swap(arr, i, j);
            }
        }
        swap(arr, left, j); // pivot swap
        System.out.println("arr = " + Arrays.deepToString(arr) + ", left = " + left + ", right = " + right);
        return j;
    }

    public static void swap(Integer[] arr, int a, int b) {
        Integer tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static void printArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + "\t");
        }
    }
    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        Integer[] arr = new Integer[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8);
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    i--;
                }
            }
        }
        long start, end;
        start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
    }
}
