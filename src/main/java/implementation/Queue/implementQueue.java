package implementation.Queue;

import java.util.NoSuchElementException;

public class implementQueue {
    static class Queue<T> {
        static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }
        private Node<T> first;
        private Node<T> last;

        public void poll(T item) {
            Node<T> t = new Node<>(item);
            if (last != null) {
                last.next = t;
            }
            last = t;
            if (first == null)
                first = last;
        }

        public T pop() {
            if (first == null) {
                throw new NoSuchElementException();
            }

            T data = first.data;
            first = first.next;

            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) {
                throw new NoSuchElementException();
            }
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.poll(1);
        q.poll(2);
        q.poll(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
    }
}
