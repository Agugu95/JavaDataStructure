package implementation.sorting;

public class mergeSort {
    public static void recursionMerge(Integer[] arr, int start, int end) {
        if (start < end) {
            int pivot = (start + end) / 2; // 분할 하기 위한 중간점
            recursionMerge(arr, start, pivot); // start - pivot
            recursionMerge(arr, pivot + 1, end); // pivot + 1 - end
            merge(arr, start, pivot, end); // merge
        }
    }

    public static void merge(Integer[] arr, int start, int pivot, int end) {
        int i = start;
        int j = pivot + 1;
        int k = start;
        Integer[] tmp = new Integer[arr.length];

        while (i <= pivot && j <= end) { // 분할된 배열 두개 모두 끝날 때까지 비교 하고 삽입
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 두 배열 모두 끝날 때까지 돌았지만 하나의 배열이라도 남아 있다면
        // 그 배열은 이미 정렬 된거기 때문에 바로 삽입
        while (i <= pivot) { //
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
        // 그리고 arraycopy로 비교 삽입한 배열을 원본에 저장
        if (end + 1 - start >= 0) {
            System.arraycopy(tmp, start, arr, start, end + 1 - start);
        }
    }

    public static void printArr(Integer[] arr) {
        for (Integer i : arr) {
            System.out.println(arr[i - 1]);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{7, 6, 8, 9, 2, 3, 4, 1, 5};
        recursionMerge(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
