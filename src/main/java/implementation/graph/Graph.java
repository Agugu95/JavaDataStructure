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
    public void addNode(int vertex, int data) {
        graph.get(vertex).add(data);
    }
}

