package implementation.sorting.quick;

public class threeQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int pivot, i, j;
        threeSort(arr, left, right, mid);
        if (right - left > 3) {
            pivot = arr[mid];
            swap(arr, mid, right - 1);
            i = left;
            j = right - 1;
            while (true) {
                while (arr[++i] < pivot);
                while (arr[--j] > pivot);
                if (i >= j) {
                    break;
                }
                swap(arr, i, j);
            }
            swap(arr, i, right - 1);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }


    public static void threeSort(Integer[] arr, int left, int right, int mid) {
        if (arr[left] >= arr[mid]) swap(arr, left, mid);
        if (arr[left] >= arr[right]) swap(arr, left, right);
        if (arr[mid] >= arr[right]) swap(arr, mid, right);
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
        Integer[] arr = new Integer[]{11, 18, 1, 20, 5, 12, 5, 16, 21, 9, 13};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
