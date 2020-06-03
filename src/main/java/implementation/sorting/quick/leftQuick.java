package implementation.sorting.quick;

import java.util.ArrayList;
import java.util.Scanner;

public class leftQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        // 재귀를 멈출 조건
        if (left <= right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

    }

    public static int partition(Integer[] arr, int left, int right) {
        int i, j, x;
        i = left + 1;
        j = right;
        x = arr[left];

        while (i < j) {
            while (arr[i] <= x) {
                i++;
            }
            while (arr[j] >= x) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
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
//        String s = sc.nextLine();
//        String[] arr = s.split(" ");
//        Integer[] iarr = new Integer[arr.length];
//        for (int i = 0; i <= arr.length - 1; i++) {
//            iarr[i] = Integer.parseInt(arr[i]);
//        }
        Integer[] iarr = new Integer[]{8, 5, 20 ,3, 15, 1, 4};
        quickSort(iarr, 0, iarr.length - 1);
        printArr(iarr);
    }
}
