package implementation.Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class utilQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i); // 요소 추가, 예외 없음
        }
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(queue.peek()); // 헤드 반환
        queue.poll(); // 헤드 제거 후 반환
        queue.offer(12); // 요소 추가, 예외 발생, 고정 크기의 경우 사용
        queue.remove(12); // 헤드 제거 후 반환, 없을 시 예외 발생
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}
