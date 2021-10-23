package implementation.graph;

import java.util.*;

public class b1260 {

    public static class Graph {
        private final List<List<Integer>> graph;
        private boolean[] visit;

        public Graph(int initSize) {
            this.graph = new ArrayList<>();
            for (int i = 0; i < initSize; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Integer> getVertex(int x) {
            return this.graph.get(x);
        }

        public void makeEdge(int preVertx, int nextVertx) {
            graph.get(preVertx).add(nextVertx);
            graph.get(nextVertx).add(preVertx);
        }

        public void bfs(int start) {
            visit[start] = true;
            Queue<List<Integer>> q = new LinkedList<>();
            q.add(graph.get(start));
            List<Integer> tmp;
            while (!q.isEmpty()) {
                System.out.println(q.peek().get(start));
                tmp = q.remove();
                for (Integer i : tmp) {
                    visit[i] = true;
                    if (!visit[i]) {
                        q.add(graph.get(i));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

       // if (((1 <= v) && (v <= 1000)) && ((1 <= e) && (e <= 10000))) {
            Graph graph = new Graph(v + 1);
            graph.makeEdge(5, 4);
            graph.makeEdge(5, 2);
            graph.makeEdge(1, 2);
            graph.makeEdge(3, 4);
            graph.makeEdge(3, 1);

            graph.bfs(start);
     //   }
    }
}
