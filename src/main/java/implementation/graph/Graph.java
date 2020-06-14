package implementation.graph;

import java.util.*;

public class Graph {
    private final List<List<Integer>> graph;

    public Graph(int initSize) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < initSize; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public List<List<Integer>> getGraph() {
        return this.graph;
    }

    public List<Integer> getVertex(int x) {
        return this.graph.get(x);
    }

    public void makeEdge(int preVertx, int nextVertx){
        graph.get(preVertx).add(nextVertx);
        graph.get(nextVertx).add(preVertx);
    }
    public void singleEdge(int vertex, int data) {
        graph.get(vertex).add(data);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.singleEdge(0, 1);
        graph.singleEdge(0,4);
        graph.makeEdge(1, 2);
        graph.makeEdge(2, 3);
        graph.makeEdge(1, 4);
        System.out.println(graph.getVertex(1));
        System.out.println(graph.getVertex(0));
        System.out.println(graph.getVertex(4));
    }
}

