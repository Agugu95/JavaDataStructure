package implementation.sorting.quick;

import java.util.Arrays;
import java.util.Random;

public class arrLibSort {
    public static void main(String[] args) { // 0.021초 Tim sort
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
        long start, end;
        start = System.currentTimeMillis();
        Arrays.sort(arr);
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
    }
}
