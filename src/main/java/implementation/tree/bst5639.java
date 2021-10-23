package implementation.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bst5639 {
    public static class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node(int input) {
            this.data = input;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }

    public Node root;
    public Node getRoot() {
        return this.root;
    }

    public void addChild(int input) { // 노드 삽입
        Node newNode = new Node(input);

        if (root != null) {
            Node moveNode = root;
            Node pointer;

            while (true) {
                pointer = moveNode;

                if (input > pointer.data) {
                    moveNode = pointer.right;
                    if (moveNode == null) {
                        pointer.right = newNode;
                        return;
                    }
                } else {
                    moveNode = pointer.left;
                    if (moveNode == null) {
                        pointer.left = newNode;
                        return;
                    }
                }
            }
        } else {
            root = newNode;
        }
    }

    public void postOrder(Node node) { // left - right - root(출력)
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        bst5639 bst = new bst5639();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            int input = Integer.parseInt(str);
            bst.addChild(input);
        }

        bst.postOrder(bst.getRoot());
    }
}