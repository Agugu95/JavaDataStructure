package implementation.sorting.merge;

public class mergeSortTwo {
    public static void mergeSort(Integer[] arr, int start, int end) {
        if (start < end) {
            int pivot = (start + end) / 2; // 중간점 계산
            mergeSort(arr, start, pivot); // 전반부 dived-conquer
            mergeSort(arr, pivot + 1, end); // 후반부 dived-conquer
            merge(arr, pivot, start, end); // merging
        }
    }

    public static void merge(Integer[] arr, int pivot, int start, int end) {
        int i = start;
        int j = pivot + 1;
        int k = start;
        Integer[] tmpArr = new Integer[arr.length];

        // 분할 된 리스트들의 정렬이 이루어지는 단계
        while (i <= pivot && j <= end) {
            if (arr[i] <= arr[j]) {
                tmpArr[k++] = arr[i++];
            } else {
                tmpArr[k++] = arr[j++];
            }
        }

        // 만약 하나라도 리스트가 남아있다면 정렬 된 상태니 일괄 복사
        if (i <= pivot) {
            for (; i <= pivot; i++)
                tmpArr[k++] = arr[i];
        }
        if (j <= end){
            for (; j <= end; j++)
                tmpArr[k++] = arr[j];
        }

        // 정렬 된 리스트 복사
        if (end + 1 - start >= 0) {
            System.arraycopy(tmpArr, start, arr, start, end + 1 - start);
        }
    }

    public static void printArray(Integer[] arr) {
        for (Integer i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 8, 3, 9, 2, 7, 6, 1};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
