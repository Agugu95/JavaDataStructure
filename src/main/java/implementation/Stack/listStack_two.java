package implementation.Stack;

import java.util.EmptyStackException;

public class listStack_two {
    private Node top;

    public listStack_two() {
        this.top = null;
    }

    public class Node {
        private String data;
        private Node nextNode;

        public Node(String data) {
            this.data = data;
            this.nextNode = null;
        }

    }

    public String push(String data) {
        Node node = new Node(data);
        node.nextNode = top;

        top = node;

        return data;
    }

    public String pop() {
        String data = peek();

        top = top.nextNode;
        return data;
    }

    public String peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean empty() {
        return top == null;
    }

    public int search(Object o) {
        int index = 1;
        Node tempTop = top;

        while (tempTop != null) {
            if (tempTop.data.equals(o))
                return index;
            tempTop = tempTop.nextNode;

            index++;
        }
        return index;
    }

    public void printStack() {
        while (top != null) {
            System.out.print(top.data + "\t");
            top = top.nextNode;
        }
    }
    public static void main(String[] args) {
        listStack_two ls = new listStack_two();
        ls.push("a");
        ls.push("b");
        ls.push("c");
        ls.printStack();
    }
}
