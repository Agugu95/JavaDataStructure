package implementation.graph;

public class unionFind {
    private final int[] tree;

    public unionFind(int initSize) {
        tree = new int[initSize];
        for (int i = 0; i < initSize; i++) {
            tree[i] = i;
        }
    }

    public int find(int x) {
        System.out.println(x);
        if (tree[x] == x) {
            return x;
        }
        return tree[x] = find(tree[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) tree[x] = y;
        else tree[y] = x;
    }

    public void printTree() {
        for (int i = 1; i < tree.length / 2; i++) {
            System.out.println(tree[i] + " " + tree[2 * i] + " " + tree[2 * i + 1]);
        }
    }

    public static void main(String[] args) {
        unionFind u = new unionFind(10);
        u.printTree();
        u.find(6);
        u.union(8, 5);
        u.printTree();
    }
}
