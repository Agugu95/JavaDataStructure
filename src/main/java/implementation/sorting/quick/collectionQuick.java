package implementation.sorting.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class collectionQuick {
    public static void main(String[] args) { // 0.021초 TimSort
        Random random = new Random(System.nanoTime());
        Integer[] arr = new Integer[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50000);
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    i--;
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        long start, end;
        start = System.currentTimeMillis();
        Collections.sort(arrayList);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
    }
}
