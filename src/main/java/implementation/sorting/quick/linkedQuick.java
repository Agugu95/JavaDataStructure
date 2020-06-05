package implementation.sorting.quick;

public class linkedQuick {
    private Node head; // head

    static class Node { // node
        private int data;
        private Node prev;
        private Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void push(int input) { // 노드 삽입
        Node newNode = new Node(input);

        if (head == null) { // 헤드가 없으면 헤드로
            head = newNode;
            return;
        }

        // 헤드가 있다면 기존 헤드 앞 삽입, 새 노드가 헤드로
        newNode.next = head;
        head.prev = newNode;
        newNode.prev = null;
        head = newNode;
    }

    Node lastNode(Node node) { // 리스트의 끝점을 잡기 위해 필요
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void quickList(Node node) {
        Node right = lastNode(node);
        quickSort(node, right);
    }

    public void quickSort(Node left, Node right) {
        //  각 노드가 겹치지 않으면 재귀
        if (right != null && left != right && left != right.next) {
            Node temp = partition(left, right);
            quickSort(left, temp.prev);
            quickSort(temp.next, right);
        }
    }

    Node partition(Node left, Node right) {
        int pivot = right.data; // 우측 끝을 피벗으로 설정
        Node i = left.prev; // 리스트의 시작 설정 배열로 치면 left - 1
        // 배열에서 for(int j = left; j <= right - 1; j++) 과 같음
        // 첫 리스트부터 끝 리스트까지 순회
        for (Node j = left; j != right; j = j.next) {
            if (j.data <= pivot) {
                // 피벗이 작으면 i++과 같음
                i = (i == null) ? left : i.next;
                // 아니라면 swap
                swap(i, j);
            }
        }
        // 탈출 시 여전히 조건을 만족 한다면
        i = (i == null) ? left : i.next;
        swap(i, right);
        return i;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "\t");
            head = head.next;
        }
    }

    public static void swap(Node i, Node j) {
        int temp = i.data;
        i.data = j.data;
        j.data = temp;
    }

    public static void main(String[] args) {
        linkedQuick list = new linkedQuick();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        list.printList(list.head);
        System.out.println();
        list.quickList(list.head);
        list.printList(list.head);
    }
}
