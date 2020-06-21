package implementation.graph.spf;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstraAlgorithm {
    private static final int INF = 1000000;
    private static final int[] d = new int[7];

    static class Graph {
        private final List<edgeSet> graph;

        public Graph(int initSize) {
            graph = new ArrayList<>(initSize);
        }

        public void singlyEdge(int u, int v, int w) { // 방향 그래프
            graph.add(new edgeSet(u, v, w));
        }

        public void doublyEdge(int u, int v, int w) {
            graph.add(new edgeSet(u, v, w));
            graph.add(new edgeSet(u, v, w));
        }

        public void dijkstra(int start) {
            d[start] = 0;
            PriorityQueue<edgeSet> pq = new PriorityQueue<>();
            pq.add(graph.get(start));
            edgeSet cur;
            while (!pq.isEmpty()) {
                cur = pq.poll();
                if (cur.w > d[cur.w]) {
                    continue;
                }
            }
        }

        public edgeSet getVertex(int x) {
            return this.graph.get(x);
        }
    }


    static class edgeSet implements Comparable<edgeSet> {
        int u, v, w;

        public edgeSet(int u, int v, int w) {
            u = this.u;
            v = this.v;
            w = this.v;
        }

        @Override
        public int compareTo(edgeSet edgeSet) {
            return Integer.compare(this.w, edgeSet.w);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            d[i] = INF;
        }
        Graph graph = new Graph(100);
        graph.singlyEdge(1, 2, 3);

    }
}
