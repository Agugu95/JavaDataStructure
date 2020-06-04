package implementation.sorting.quick;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class midQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(Integer[] arr, int left, int right) {
        // pivot은 정렬에서 제외 되어야함
        int pivot = (left + right) / 2;
        swap(arr, left, pivot);
       // System.out.println("pivot = " + arr[pivot] + ", left = " + left + ", right = " + right);

        while (left < right) {
            while (arr[pivot] > arr[left]) { // pivot보다 큰 값 탐색
                left++;
            }
            while (arr[pivot] < arr[right] && left < right) { // pivot보다 작은 값 탐색
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivot, right);
       // System.out.println("arr = " + Arrays.deepToString(arr) + ", Left = " + left + ", Right = " + right);
        return pivot;
    }

    public static void swap(Integer[] arr, int a, int b) {
        Integer tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void printArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + "\t");
        }
    }
    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        Integer[] arr = new Integer[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
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
