package implementation.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Kruskal {
    // n개 노드, n - 1개 에지
    // union find
    // 오름차순 정렬

    static class Graph {
        private final List<edgeSet> graph;

        Graph(int initSize) {
            graph = new ArrayList<>(initSize);
        }

        public void makeEdge(int u, int v, int w) {
            graph.add(new edgeSet(u, v, w));
        }

        public List<edgeSet> getGraph() {
            return this.graph;
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
        unionFind union = new unionFind(1000);
        Graph graph = new Graph(1000);
        graph.makeEdge(1, 2, 4);
        graph.makeEdge(1, 4, 2);
        graph.makeEdge(4, 5, 7);
        graph.makeEdge(4, 2, 12);
        graph.makeEdge(2, 6, 8);
        graph.makeEdge(2, 7, 1);
        graph.makeEdge(4, 7, 3);
        Collections.sort(graph.getGraph());
        for (edgeSet i : graph.getGraph()) {
            System.out.println(i.toString());
        }
        int sum = 0;
        for (edgeSet edge : graph.getGraph()) {
            if (!union.connected(edge.u, edge.v)) {
                sum += edge.w;
                union.rankUnion(edge.u, edge.v);
            }
        }
        System.out.println(sum);
    }
}
