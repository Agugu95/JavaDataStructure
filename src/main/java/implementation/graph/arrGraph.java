package implementation.graph;

import java.util.Arrays;

public class arrGraph {
    // 재할당 불가, 값 변경 가능, 새 할당시 인스턴스화(계속 만들 수 있음)ㅏ
    private final int[][] arrGraph;

    public arrGraph(int initSize) { // ArrayOutOfIndex 예방
        initSize = initSize + 1;
        arrGraph = new int[initSize][initSize];
    }

    public void singleEdge(int preVertx, int nextVertx) {
        arrGraph[preVertx][nextVertx] = 1;
    }

    public void makeEdge(int preVertx, int nextVertx) {
        arrGraph[preVertx][nextVertx] = arrGraph[nextVertx][preVertx] = 1;
    }

    public int[] getVertex(int vertx) {
        return this.arrGraph[vertx];
    }

    public void printGraph() {
        // 배열 순회도 향상 된 for
        for (int[] i : arrGraph) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        arrGraph graph = new arrGraph(5);
        graph.makeEdge(0, 2);
        graph.makeEdge(1, 4);
        graph.makeEdge(3, 4);
        graph.makeEdge(2, 1);
        System.out.println(Arrays.toString(graph.getVertex(4)));
        graph.printGraph();
    }
}
