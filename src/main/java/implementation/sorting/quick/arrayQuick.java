package implementation.sorting.quick;

public class arrayQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int pivot = divide(arr, left, right); // pivot 결정과 분할
            quickSort(arr, left, pivot - 1); // data <= pivot 정렬
            quickSort(arr, pivot + 1, right); // data >= pivot 정렬
        }

    }

    public static int divide(Integer[] arr, int left, int right) {
        int i, j, x;
        i = left - 1;
        j = left;
        x = arr[right];
        while (j <= right - 1) {
            if (arr[j] <= x) {
                ++i;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i + 1, right);
        return i + 1;
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
        Integer[] arr = new Integer[]{8, 5, 20, 3, 15, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
