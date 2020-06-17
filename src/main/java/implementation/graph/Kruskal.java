package implementation.graph;

public class Kruskal {
    // n개 노드, n - 1개 에지
    // union find
    // 오름차순 정렬

    static class edgeSet implements Comparable<edgeSet> {
        private int u, v, w;

        edgeSet(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }


        @Override
        public int compareTo(edgeSet edgeSet) {
            return Integer.compare(this.v, edgeSet.v);
        }
    }


    public static void main(String[] args) {
        unionFind union = new unionFind(1000);
    }
}
