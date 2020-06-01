package implementation.sorting;

public class mergeSort {
    public static void recursionMerge(Integer[] arr, int start, int end) {
        if (start < end) {
            int pivot = (start + end) / 2;
            recursionMerge(arr, start, pivot);
            recursionMerge(arr, pivot + 1, end);
            recursionMerge(arr, start, end);
            combine(arr,  start, pivot, end);
        }
    }

    public static void combine (Integer[] arr,  int start, int pivot,int end) {
        int i = start;
        int j = pivot + 1;
        int k = 0;


    }

    public static void main(String[] args) {

    }
}
