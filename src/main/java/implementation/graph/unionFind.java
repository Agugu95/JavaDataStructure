package implementation.graph;

public class unionFind {
    private final int[] tree, rank, size;

    public unionFind(int initSize) {
        tree = new int[initSize];
        rank = new int[initSize];
        size = new int[initSize];
        init();
    }

    public void init() {
        for (int i = 1; i < tree.length; i++) {
            tree[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }
    }

    public int find(int x) {
        return (tree[x] == x) ? x : (tree[x] = find(tree[x]));
    }

    public void rankUnion(int x, int y) {
        x = find(x);
        y = find(y);
        // 동일 루트면 종료
        if (x == y) {
            return;
        }
        // 트리 x보다 y가 작다면 x를 작게 만듬
        if (rank[x] > rank[y]) {
            tree[y] = x;
        } else { // 반대면 반대로
            tree[x] = y;
        }
        // 만약 트리 둘의 레벨이 같다면 union 됐으니 레벨 1 증가
        if (rank[x] == rank[y]) {
            rank[x]++;
        }
    }


    public void weightedUnion(int x, int y) {
        x = find(x);
        y = find(y);
        // 동일 루트면 종료
        if (x == y) return;
        tree[x] = tree[y];
        size[x] += size[y];
    }

    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    public void printArr() {
        System.out.println("arr");
        for (int i = 1; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public void printRank() {
        System.out.println("rank");
        for (int i = 1; i < rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
        System.out.println();
    }

    public void printSize() {
        System.out.println("size");
        for (int i = 1; i < size.length; i++) {
            System.out.print(size[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        unionFind u = new unionFind(8);
        u.rankUnion(5, 7);
        u.rankUnion(3, 2);
        u.rankUnion(4, 2);
        u.rankUnion(1, 5);
        u.rankUnion(4, 7);
        u.printArr();
        u.printRank();
        u.printSize();
        u.connected(1, 3);
        u.find(4);
        u.printArr();
        u.find(3);
        u.printArr();
    }
}
