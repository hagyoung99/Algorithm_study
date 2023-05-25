package thursday.week27.jinu;

import java.io.*;
import java.util.*;

public class BOJ1261 {

    static int N, M;
    static int[][] map;
    static int answer = 9999;
    static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static StringTokenizer st;

    static class RC implements Comparable<RC> {
        int r, c;
        int cnt;

        public RC(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(RC o) {
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        PriorityQueue<RC> queue = new PriorityQueue<>();
        queue.offer(new RC(0, 0, 0));
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            RC temp = queue.poll();

            if (temp.r == N - 1 && temp.c == M - 1) {
                answer = Math.min(temp.cnt, answer);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = temp.r + deltas[i][0];
                int nc = temp.c + deltas[i][1];

                if (isIn(nr, nc) && !visited[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        queue.offer(new RC(nr, nc, temp.cnt));
                    }
                    if (map[nr][nc] == 1) {
                        queue.offer(new RC(nr, nc, temp.cnt + 1));
                    }
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}