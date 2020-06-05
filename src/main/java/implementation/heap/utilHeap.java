package implementation.heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class utilHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        p.add(10);
        p.add(30);
        p.add(400);
        p.add(5);
        p.add(347);

        System.out.println(p.peek());
        for (Integer i : p) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (Integer i : p) {
            System.out.print(i + "\t");
        }
        p.remove(30);
        System.out.println();
        for (Integer i : p) {
            System.out.print(i + "\t");
        }
        p.poll();
        System.out.println();
        Object[] arr = p.toArray();
        for (Object i : arr) {
            System.out.print(i + "\t");
        }
    }
}
