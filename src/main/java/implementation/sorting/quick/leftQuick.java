package implementation.sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
        //System.out.println("pivot = " + arr[left]);
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
        //System.out.println("arr = " + Arrays.deepToString(arr) + ", left = " + left + ", right = " + right);
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
//        System.out.print("input : ");
//        String s = sc.nextLine();
//       // String s = sc.nextLine().replace(" ", "");
//       // String[] arr = s.split("");
//        String[] arr = Stream.of(s.split(",")).map(String::trim).toArray(String[]::new);
//        Integer[] iarr = new Integer[arr.length];
//        for (int i = 0; i <= arr.length - 1; i++) {
//            iarr[i] = Integer.parseInt(arr[i]);
//        }
        Random random = new Random(System.nanoTime());
        Integer[] iarr = new Integer[10000];
        for (int i = 0; i < iarr.length; i++) {
            iarr[i] = random.nextInt(10000);
            for (int j = 0; j < i; j++) {
                if (iarr[i].equals(iarr[j])) {
                    i--;
                }
            }
        }
        long start, end;
        start = System.currentTimeMillis();
        quickSort(iarr, 0, iarr.length - 1);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
    }
}

