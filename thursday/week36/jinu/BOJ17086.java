package thursday.week36.jinu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {

    static int[][] map;
    static boolean[][] visit;
    static int N, M;
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class Pos {
        int y, x, d;

        public Pos(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int val = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    continue;
                val = Math.max(val, bfs(i, j));
            }
        }

        System.out.println(val);
    }

    public static int bfs(int y, int x) {
        Queue<Pos> q = new LinkedList<Pos>();
        q.add(new Pos(y, x, 0));
        visit = new boolean[N][M];
        visit[y][x] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int dir = 0; dir < 8; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if (isInRange(ny, nx))
                    continue;
                if (visit[ny][nx])
                    continue;
                if (map[ny][nx] == 1) {
                    return cur.d + 1;
                }

                visit[ny][nx] = true;
                q.add(new Pos(ny, nx, cur.d + 1));
            }
        }

        return 0;
    }

    public static boolean isInRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= M;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

}
