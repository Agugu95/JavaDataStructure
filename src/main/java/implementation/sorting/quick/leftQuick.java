package implementation.sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class leftQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        // 재귀를 멈출 조건
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

    }

    public static int partition(Integer[] arr, int left, int right) {
        int i = left;
        int j = right;
        int newPivot;
        while (i < j) {
            while (arr[left] > arr[i]) { // pivot >= data
                i++;
            }
            while (arr[left] <= arr[j] &&  i < j) { // pivot <= data, outOfIndex
                j--;
            }
            if (i < j) { // swap
                swap(arr, i, j);
            }
        }
        swap(arr, left, j); // pivot swap
        newPivot = j;
        return newPivot;
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
//        Scanner sc = new Scanner(System.in);
//        System.out.print("input : ");
//        String s = sc.nextLine();
//       // String s = sc.nextLine().replace(" ", "");
//       // String[] arr = s.split("");
//        String[] arr = Stream.of(s.split(",")).map(String::trim).toArray(String[]::new);
//        Integer[] iarr = new Integer[arr.length];
//        for (int i = 0; i <= arr.length - 1; i++) {
//            iarr[i] = Integer.parseInt(arr[i]);
//        }
        Integer[] iarr = new Integer[]{3, 8, 0, 7, 6, 4, 1, 5, 2, 4, 5, 8, 11, 2, 35, 3, 0 , 325, 53, 2, 129};
        quickSort(iarr, 0, iarr.length - 1);
        printArr(iarr);
    }
}
