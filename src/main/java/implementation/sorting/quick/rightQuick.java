package implementation.sorting.quick;

public class rightQuick {
    public static void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int pivot = ascPartition(arr, left, right); // pivot 결정과 분할
            quickSort(arr, left, pivot - 1); // data <= pivot 정렬
            quickSort(arr, pivot + 1, right); // data >= pivot 정렬
        }

    }

    public static int ascPartition(Integer[] arr, int left, int right) {
        int i, j, x;
        i = left - 1; // -1
        j = left; // 0
        x = arr[right]; // pivot
        while (j <= right - 1) { // pivot - 1까지 순회
            if (arr[j] <= x) { // pivot보다 작은 값이면
                ++i; // i 증가 시키고 스왑
                swap(arr, i, j);
            }
            j++; // j 증가
        }
        swap(arr, i + 1, right); // pivot보다 작은 값만 앞에 남았으니 스왑
        return i + 1; // 새 pivot 결정
    }

    public static int descPartition(Integer[] arr, int left, int right) {
        int i, j, x;
        i = left - 1; // -1
        j = left; // 0
        x = arr[right]; // pivot
        while (j <= right - 1) { // pivot - 1까지 순회
            if (arr[j] >= x) { // pivot보다 작은 값이면
                ++i; // i 증가 시키고 스왑
                swap(arr, i, j);
            }
            j++; // j 증가
        }
        swap(arr, i + 1, right); // pivot보다 작은 값만 앞에 남았으니 스왑
        return i + 1; // 새 pivot 결정
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
