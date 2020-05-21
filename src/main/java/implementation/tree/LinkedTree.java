package implementation.tree;

import java.lang.Comparable;

public class LinkedTree {
    private static class Node {
        private int data;
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


    private Node root;
    private int count = 0;


    public Node getRoot() {
        return this.root;
    }


    public void addChild(int input) {
        Node node = new Node(input);
        if (root == null) {
            root = node;
            count++;
        }
        if (count % 2 == 1) {
            root.left = node;
        } else {
            root.right = node;
        }
        count++;
    }

    public void inOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            inOrder(node.getLeft());
            //System.out.println(node.data);
            inOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        LinkedTree tree = new LinkedTree();
        tree.addChild(1);
        tree.addChild(2);
        tree.addChild(3);
        tree.inOrder(tree.getRoot());
        tree.addChild(4);
        tree.addChild(5);
        tree.inOrder(tree.root.left);
        tree.addChild(6);
        tree.addChild(7);
    }
}
