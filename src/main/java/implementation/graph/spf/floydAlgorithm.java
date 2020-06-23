package implementation.graph.spf;

import java.util.Arrays;

public class floydAlgorithm {
    private static final long INF = Integer.MAX_VALUE;
    private final long[][] graph = new long[][]{
            {0, 4, 1, 1, INF},
            {4, 0, INF, INF, 8},
            {1, INF, 0, 3, 15},
            {1, INF, 3, 0, 6},
            {INF, 8, 15, 6, 0}};

    public void floyd() {
        long[][] spfArr = new long[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) { // 수행 할 배열
            System.arraycopy(graph[i], 0, spfArr[i], 0, spfArr.length);
        }
        for (int i = 0; i < spfArr.length; i++) { // 자기 자신으로 가는 길은 거리 0
            spfArr[i][i] = 0;
        }
        for (int k = 0; k < spfArr.length; k++) { // 거치는 정점 K
            for (int i = 0; i < spfArr.length; i++) { // 정점 K에 대해 모든 정점 순회
                for (int j = 0; j < spfArr.length; j++) {
                    // 기존 거리와 정점을 거치는 거리 비교
                    spfArr[i][j] = Math.min(spfArr[i][j], (spfArr[i][k] + spfArr[k][j]));
                }
            }
            for (long[] i : spfArr) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println();
        }
    }

    public void traceFloyd() {
    }

    public static void main(String[] args) {
        // floyd 3-for-loop
        floydAlgorithm floyd = new floydAlgorithm();
        floyd.floyd();
    }
}
