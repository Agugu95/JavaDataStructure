package implementation.tree;

public class failureTree {
    private static class Node {
        private int data;
        private Node left, right;
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

    public Node searchingNode(int input) {
        if (root == null) {
            return null;
        }
        Node moveNode = root;
        while (moveNode.data != input) {
            if (input < moveNode.data) {
                moveNode = moveNode.left;
            } else {
                moveNode = moveNode.right;
            }
            if (moveNode == null) {
                return null;
            }
        }
        return moveNode;
    }


    public void addChild(int input) {
        if (searchingNode(input) != null) {
            return;
        }

        Node newNode = new Node(input);

        if (root == null) { // 트리가 없다면 root 생성
            root = newNode;
        } else {
            Node moveNode = root;
            Node pointer;

            while (true) {
                pointer = moveNode;

                if (input < pointer.data) {
                    moveNode = pointer.left;

                    if (moveNode == null) {
                        pointer.left = newNode;
                        return;
                    }
                } else {
                    moveNode = pointer.right;

                    if (moveNode == null) {
                        pointer.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.data);
            inOrder(node.getRight());
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.data);
        }
    }


    public static void main(String[] args) {
        failureTree tree = new failureTree();
        tree.addChild(6);
        tree.addChild(4);
        tree.addChild(2);
        tree.addChild(5);
        tree.addChild(9);
        tree.addChild(8);
        tree.addChild(11);
        tree.addChild(10);
        tree.addChild(13);
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.preOrder(tree.getRoot());
        System.out.println();
        tree.postOrder(tree.getRoot());
        System.out.println();
        System.out.println(tree.searchingNode(8));
    }
}
