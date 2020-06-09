package implementation.sorting.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class lib_heapSort {
    // 자바 우선 순위 큐를 이용한 힙 소트
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Random rand = new Random();
        for (int i = 0; i <= 10; i++) {
            pq.offer(rand.nextInt(20));
        }
        for (Integer i : pq) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(pq.poll());
        for (Integer i : pq) {
            System.out.print(i + " ");
        }
    }
}
