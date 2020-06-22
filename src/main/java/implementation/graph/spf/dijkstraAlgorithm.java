package implementation.graph.spf;

import java.util.*;

public class dijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dist = new int[9];

    static class Graph {
        private final List<List<vertexSet>> graph;

        public Graph(int initSize) {
            graph = new ArrayList<>(initSize);
            for (int i = 1; i <= initSize; i++) {
                graph.add(new LinkedList<>());
            }
        }

        public void singlyEdge(int u, int v, int w) { // 방향 그래프
            graph.get(u).add(new vertexSet(v, w));
        }

        public void doublyEdge(int u, int v, int w) { // 무방향 그래프
            graph.get(u).add(new vertexSet(v, w));
            graph.get(v).add(new vertexSet(u, w));
        }

        public void dijkstra(int start) {
            dist[start] = 0; // 시작 정점인 자기 자신에 대한 거리는 0
            PriorityQueue<vertexSet> pq = new PriorityQueue<>(); // 최소값
            vertexSet cur;
            pq.add(new vertexSet(start, 0)); // 1 -> 1, 가중치 0
            // 각 정점 비교
            while (!pq.isEmpty()) {
                cur = pq.poll(); // 시작 정점
                int curV = cur.v; // 시작 정점이 가진 다음 정점
                int curW = cur.w; // 시작 정점이 가진 가중치
                if (dist[curV] < curW) { // 가중치를 통한 거리 계산, 만약 기존 거리가 더 짧다면 패스
                    continue;
                }
                for (int i = 0; i < graph.get(curV).size(); i++) { // 인접 정점에 대한 Relaxation
                    int nextV = graph.get(curV).get(i).v; // 기준 정점으로부터 인접 정점
                    int nextW = graph.get(curV).get(i).w; // 기준 정점으로부터 인접 정점 가중치
                    if (dist[nextV] > curW + nextW) { // Relaxation
                        dist[nextV] = curW + nextW;
                        pq.add(new vertexSet(nextV, dist[nextV])); // Relaxation 후 다음 정점 추가
                    }
                }
            }
        }

        public List<vertexSet> getVertex(int x) {
            return this.graph.get(x);
        }

        public List<List<vertexSet>> getGraph() {
            return this.graph;
        }
    }


    static class vertexSet implements Comparable<vertexSet> {
        int v, w;

        public vertexSet(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(vertexSet vertexSet) {
            return Integer.compare(this.w, vertexSet.w);
        }

        @Override
        public String toString() {
            return "V=" + this.v + " W=" + this.w;
        }

    }

    public static void main(String[] args) {
        Arrays.fill(dist, INF);
        Graph graph = new Graph(100);
        graph.singlyEdge(1, 2, 3);
        graph.singlyEdge(1, 3, 2);
        graph.singlyEdge(1, 4, 5);
        graph.singlyEdge(2, 3, 2);
        graph.singlyEdge(2, 5, 8);
        graph.singlyEdge(3, 4, 2);
        graph.singlyEdge(4, 5, 6);
        graph.singlyEdge(5, 6, 1);
        graph.dijkstra(1);
        System.out.println(Arrays.toString(dist));
        Arrays.fill(dist, INF);
        graph.dijkstra(5); // 방향 그래프라 6밖에 갈 수 없음
        System.out.println(Arrays.toString(dist));
    }
}
