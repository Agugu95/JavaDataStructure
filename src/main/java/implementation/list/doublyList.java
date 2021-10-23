package implementation.list;

public class doublyList {
    public static class Node {
        private final int data;
        private Node next;
        private Node prev;

        public Node(int input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int input) {
        Node newNode = new Node(input);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        if (head.next == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(int input) {
        // 삽입 시 데이터가 없다면 앞이나 끝이나 같다
        if (size == 0) {
            addFirst(input);
        } else {
            Node newNode = new Node(input);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public Object removeFirst() {
        if (size == 0) {
            return null;
        }
        Node removeNode = head;
        head = null;
        head = removeNode.next;
        head.prev = null;
        size--;
        return removeNode.data;
    }

    public Object removeLast() {
        if (size == 0) {
            removeFirst();
        }
        Node removeNode = tail;
        tail = null;
        tail = removeNode.prev;
        tail.next = null;
        size--;
        return removeNode.data;
    }

    public void addPoint(int point, int input) {
        if (size == 0) {
            addFirst(input);
        } else if (point == size - 1) {
            addLast(input);
        } else {
            Node newNode = new Node(input);
            Node prevNode = checkNode(point);
            Node nextNode = prevNode.next;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    public Node checkNode(int point) {
        if (point < size / 2) { // 중간보다 앞에 삽입
            Node node = head;
            for (int i = 0; i <= point; i++) {
                node = node.next;
            }
            return node;
        } else { // 중간보다 뒤에 삽입
            Node node = tail;
            for (int i = size; i > point; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int isSize() {
        return size;
    }

    public void printList() {
        if (size == 0) {
            isEmpty();
        }
        Node node = head;
        System.out.print(node.data + "\t");
        while(node.next != null){
            node = node.next;
            System.out.print(node.data + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doublyList list = new doublyList();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        list.addPoint(2, 5);
        list.printList();
        System.out.println(list.isEmpty());
        System.out.println(list.isSize());
        list.addPoint(5, 6);
        list.printList();
    }
}
