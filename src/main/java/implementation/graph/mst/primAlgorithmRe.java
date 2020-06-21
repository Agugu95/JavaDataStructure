package implementation.graph.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class primAlgorithmRe {
    static boolean[] visited;

    static class Graph {
        private final List<List<edgeSet>> graph;

        Graph(int initSize) {
            graph = new ArrayList<>(initSize);
            for (int i = 0; i < initSize; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void makeEdge(int u, int v, int w) {
            graph.get(u).add(new edgeSet(u, v, w));
        }

        public List<List<edgeSet>> getGraph() {
            return this.graph;
        }

        public ArrayList<edgeSet> prim() {
            // 시작 정점
            // 시작 정점에서 가장 최소치인 간선
            // 방문 안했다면 선택

            PriorityQueue<edgeSet> pq = new PriorityQueue<>();
            ArrayList<edgeSet> mst = new ArrayList<>();
            pq.add(graph.get(1).get(0));
            int now = 0;
            if (pq.peek() != null) {
                now = pq.peek().u;
            }
            visited[now] = true;
            while (!pq.isEmpty()) {
            }
            return mst;
        }
    }

    static class edgeSet implements Comparable<edgeSet> {
        int u, v, w;

        edgeSet(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(edgeSet edgeSet) {
            // the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
            return Integer.compare(this.w, edgeSet.w);
        }

        @Override
        public String toString() {
            return "U= " + this.u + " V= " + this.v + " W= " + this.w;
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(1001);
        visited = new boolean[1001];
        graph.makeEdge(1, 2, 4);
        graph.makeEdge(1, 4, 2);
        graph.makeEdge(4, 5, 7);
        graph.makeEdge(4, 2, 12);
        graph.makeEdge(2, 6, 8);
        graph.makeEdge(2, 7, 1);
        graph.makeEdge(4, 7, 3);
        System.out.println(graph.prim());
    }
}