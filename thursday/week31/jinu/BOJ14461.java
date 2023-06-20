package thursday.week31.jinu;

import java.util.*;
import java.io.*;

public class BOJ14461 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int t;
        int cnt;

        public Node(int x, int y, int t, int cnt) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.cnt = cnt;

        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }

    static int next_x[] = { 1, -1, 0, 0 };
    static int next_y[] = { 0, 0, 1, -1 };

    static int map[][];
    static int w[][][];
    static int n;
    static int T;
    static int INF = Integer.MAX_VALUE;

    static void Dekkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0, 0));
        for (int i = 0; i < 3; i++)
            w[0][0][i] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.t > w[now.x][now.y][now.cnt])
                continue;
            for (int i = 0; i < 4; i++) {
                int nextx = now.x + next_x[i];
                int nexty = now.y + next_y[i];

                if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= n)
                    continue;

                int t = now.t + T;

                if (now.cnt != 2 && w[nextx][nexty][now.cnt + 1] > t) {
                    w[nextx][nexty][now.cnt + 1] = t;
                    queue.add(new Node(nextx, nexty, t, now.cnt + 1));
                } else if (now.cnt == 2 && w[nextx][nexty][0] > t + map[nextx][nexty]) {
                    w[nextx][nexty][0] = t + map[nextx][nexty];
                    queue.add(new Node(nextx, nexty, t + map[nextx][nexty], 0));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        w = new int[n][n][3];

        for (int arrs[][] : w) {
            for (int arr[] : arrs) {
                Arrays.fill(arr, INF);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dekkstra();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(w[n - 1][n - 1][i], ans);
        }
        System.out.println(ans);
    }
}
