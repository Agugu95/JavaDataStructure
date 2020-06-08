package implementation.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class util_Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minP = new PriorityQueue<>(); // min heap
        PriorityQueue<Integer> maxP = new PriorityQueue<>(Collections.reverseOrder());

        minP.add(10);
        minP.add(30);
        minP.add(400);
        minP.add(5);
        minP.add(347);
        minP.add(23);
        minP.add(212);

        maxP.add(10);
        maxP.add(30);
        maxP.add(400);
        maxP.add(5);
        maxP.add(347);
        maxP.add(23);
        maxP.add(212);
        maxP.add(65);

        System.out.println(minP.peek());
        for (Integer i : minP) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println(maxP.peek());
        for (Integer i : maxP) {
            System.out.print(i + "\t");
        }

        minP.poll();
        minP.add(65);
        minP.remove(212);
        System.out.println();
        Object[] arr = minP.toArray();
        for (Object i : arr) {
            System.out.print(i + "\t");
        }
    }
}
