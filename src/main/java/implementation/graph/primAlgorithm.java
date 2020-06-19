package implementation.graph;

import java.util.*;

public class primAlgorithm {
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


        public ArrayList<edgeSet> prim() {
            // 시작 정점
            // 시작 정점에서 가장 최소치인 간선
            // 방문 안했다면 선택

            PriorityQueue<edgeSet> pq = new PriorityQueue<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(graph.indexOf(graph.get(1)));
            ArrayList<edgeSet> mst = new ArrayList<>();

            while (!queue.isEmpty()) {
                int now = queue.poll();
                visited[now] = true;

                for (edgeSet set : graph.get(now)) {
                    if (!visited[set.v]) {
                        pq.add(set);
                    }
                }
                while (!pq.isEmpty()) {
                    edgeSet set = pq.poll();
                    if (!visited[set.v]) {
                        queue.add(set.v);
                        visited[set.v] = true;
                        mst.add(set);
                        break;
                    }
                }
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