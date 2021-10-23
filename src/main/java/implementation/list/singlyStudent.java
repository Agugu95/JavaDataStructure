package implementation.list;

public class singlyStudent {
    public static class Node {
        private final int age;
        private final int number;
        private final String name;
        private Node next;

        public Node(int age, int number, String name) {
            this.age = age;
            this.number = number;
            this.name = name;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void addFirst(int age, int number, String name) {
        Node newNode = new Node(age, number, name);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void printList(String name) {
        if (size == 0) {
            System.out.println("size =  " + 0);
        }
        Node node = head;
        System.out.print("head = " + node.name + "\t");
        while(node.next != null){
            node = node.next;
            if (node.name.equals(name)) {
                System.out.print("name: " + node.name + " age: " + node.age + " number: " + node.number + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        singlyStudent list = new singlyStudent();
        list.addFirst(20, 1, "a");
        list.addFirst(20, 2, "b");
        list.addFirst(20, 3, "c");
        list.addFirst(20, 4, "d");

        list.printList("c");
    }
}
