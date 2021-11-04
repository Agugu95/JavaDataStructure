package implementation.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력
4 5 1
1 2
1 3
1 4
2 4
3 4

예제 출력
1 2 4 3
1 2 3 4
 */
public class bfs_1260 {

    public static class Graph {
        private final List<List<Integer>> graph;
        private final boolean[] visited = new boolean[1001];

        // 그래프
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

        // 무방향 그래프 연결
        public void makeEdge(int preVertx, int nextVertx) {
            graph.get(preVertx).add(nextVertx);
            graph.get(nextVertx).add(preVertx);
        }

        public void bfs(int start) {
            visited[start] = true;
            Queue<List<Integer>> q = new LinkedList<>();
            q.offer(graph.get(start));
            List<Integer> tmp;

            while (!q.isEmpty()) {
                tmp = q.poll();
                System.out.println(tmp);

                for (Integer i : tmp) {
                    visited[i] = true;
                    if (!visited[i]) {
                        q.add(graph.get(i));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int vert = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(vert + 1);

        System.out.println(vert + " " + edge + " " + start);

        System.out.println(graph.getGraph());

        for (int i = 0; i < edge; i++) {
            String in = br.readLine();
            StringTokenizer s = new StringTokenizer(in);
            int v1 = Integer.parseInt(s.nextToken());
            int v2 = Integer.parseInt(s.nextToken());
            graph.makeEdge(v1, v2);
        }

        System.out.println(graph.getGraph());
        graph.bfs(start);
    }
}
