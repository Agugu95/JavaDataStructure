package implementation.Deque;

public class implementDeque {

    public static class DequeNode {
        char data;
        DequeNode prev;
        DequeNode next;

        public DequeNode(){
            this.prev = null;
            this.next = null;
        }

        public DequeNode(char data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static class Deque {
        DequeNode front;
        DequeNode rear;

        public Deque() {
            front = null;
            rear = null;
        }

        public boolean isEmpty() {
            return (front == null);
        }

        public void pushFront(char data) {
            DequeNode node = new DequeNode(data);
            if (isEmpty()) {
                front = node;
                rear = node;
                node.next = null;
                node.prev = null;
            } else {
                node.next = front;
                node.prev = null;
                front.prev = node;
                front = node;
            }
        }

        public char deleteFront() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
                return 0;
            } else {
                char data = front.data;
                if (front.next == null) {
                    front = null;
                    rear = null;
                } else {
                    front = front.next;
                    front.prev = null;
                }
                return data;
            }
        }

        public void pushRear(char data) {
            DequeNode node = new DequeNode(data);
            if (isEmpty()) {
                front = node;
                rear = node;
                node.next = null;
                node.prev = null;
            } else {
                node.prev = rear;
                node.next = null;
                rear.next = node;
                rear = node;
            }
        }

        public char deleteRear() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
                return 0;
            } else {
                char data = rear.data;
                if (rear.prev == null) {
                    front = null;
                    rear = null;
                } else {
                    rear = rear.prev;
                    rear.next = null;
                }
                return data;
            }
        }

        public void removeFront() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
            } else {
                if (front.next == null) {
                    front = null;
                    rear = null;
                } else {
                    front = front.next;
                    front.prev = null;
                }
            }
        }

        public void removeRear() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
            } else {
                if (rear.prev == null) {
                    front = null;
                    rear = null;
                } else {
                    rear = rear.prev;
                    rear.next = null;
                }
            }
        }

        public char peekFront() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
                return 0;
            } else {
                return front.data;
            }
        }

        public char peekRear() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
                return 0;
            } else {
                return rear.data;
            }
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("deque가 비어있습니다.");
            } else {
                DequeNode node = front;
                while (node != null) {
                    System.out.println(node.data + " ");
                    node = node.next;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char deletedDate;
        Deque dq = new Deque();

        dq.pushFront('A');
        dq.print(); // 들어간게 A뿐이라 A출력
        dq.removeFront();
        dq.pushRear('B');
        dq.print(); // AB 출력

    }
}
