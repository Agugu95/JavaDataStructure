package implementation.sorting;

public class selectionSort {
    public static void swap(Integer[] arr, int prev, int next) {
        int temp = arr[prev];
        arr[prev] = arr[next];
        arr[next] = temp;
    }

    public static void simplySort(Integer[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                swap(arr, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr =new Integer[]{6,5,4,3,2,1};
        simplySort(arr, arr.length);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
