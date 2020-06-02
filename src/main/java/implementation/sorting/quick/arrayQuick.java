package implementation.sorting.quick;

public class arrayQuick {
    public static void quickSort(Integer[] arr, int start, int end) {
        if (start < end) {
            int pivot = divide(arr, start, end); // pivot 결정과 분할
            quickSort(arr, start, pivot - 1); // data <= pivot 정렬
            quickSort(arr, pivot + 1, end); // data >= pivot 정렬
        }

    }

    public static int divide(Integer[] arr, int start, int end) {
        int j = start;
        int i = start - 1;
        int p = arr[end];
        while (j <= end - 1) {
            if (arr[j] <= p) {
                i++;
                swap(arr, i, end);
            }
            j++;
        }
        swap(arr, i + 1, end);
        return j + 1;
    }

    public static void swap(Integer[] arr, int a, int b) {
        Integer tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void printArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 5, 20, 3, 15, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
