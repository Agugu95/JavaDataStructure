package implementation.Deque;

import java.util.ArrayDeque;

public class utilDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(4);
        printDQ(dq);
        System.out.println();
        dq.offer(2);
        printDQ(dq);
        System.out.println();
        dq.push(7);
        printDQ(dq);
        System.out.println();
        dq.push(12);
        printDQ(dq);
        System.out.println();
        dq.addFirst(3);
        dq.addLast(24);

        printDQ(dq);
        System.out.println();
    }

    public static void printDQ(ArrayDeque<Integer> dq) {
        for (int i : dq) {
            System.out.print(i + " ");
        }
    }
}
