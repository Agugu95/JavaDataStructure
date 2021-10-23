package implementation;

import java.io.*;
import java.util.*;

public class bj_2178 {
    public static boolean[][] visited = new boolean[1001][1001];
    public static int[][] arr;
    public static int n, m;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] location = q.poll();
            visited[i][j] = true;

            for (int dist = 0; dist < 4; dist++) {
                int x = location[0] + dx[dist];
                int y = location[1] + dy[dist];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (arr[x][y] != 0 && !visited[x][y]) {

                        q.offer(new int[]{x, y});

                        visited[x][y] = true;

                        arr[x][y] = arr[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                // ascii code charAt() - '0'
            }
        }

        bfs(0, 0);

        System.out.println(arr[n - 1][m - 1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
