package implementation.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class priorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int data = 0;
        if (input != 0 && input < 100001) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(1000000, Collections.reverseOrder());
            while (input != 0) {
                data = sc.nextInt();
                if (data != 0) {
                    pq.add(data);
                } else {
                    if (pq.peek() == null) {
                        System.out.println(0);
                    } else {
                        System.out.println(pq.poll());
                    }
                }
                input--;
            }
        }
    }
}
