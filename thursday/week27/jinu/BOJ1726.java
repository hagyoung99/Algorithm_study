package thursday.week27.jinu;

import java.util.*;
import java.io.*;

public class BOJ1726 {

    static int M, N, map[][];
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Robot[] position = new Robot[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            // 방향 세팅
            if (c == 1)
                c = 1; // 동
            else if (c == 2)
                c = 3; // 서
            else if (c == 3)
                c = 2; // 남
            else if (c == 4)
                c = 0; // 북

            position[i] = new Robot(a, b, c, 0);
        }

        System.out.println(process(position[0], position[1]));
    }

    private static int process(Robot start, Robot end) {

        boolean[][][] visited = new boolean[4][M][N];
        Queue<Robot> q = new LinkedList<>();
        visited[start.dir][start.r][start.c] = true;
        q.add(new Robot(start.r, start.c, start.dir, start.cnt));

        while (!q.isEmpty()) {

            Robot now = q.poll();
            // 도착 지점에 도달
            if (now.r == end.r && now.c == end.c && now.dir == end.dir)
                return now.cnt;

            // 해당 방향으로 이동(최대 3 칸)
            for (int i = 1; i <= 3; i++) {
                int rr = now.r + dr[now.dir] * i;
                int cc = now.c + dc[now.dir] * i;
                // 범위를 초과하거나 갈 수 없는 곳이라면 break
                if (rr < 0 || cc < 0 || rr >= M || cc >= N || map[rr][cc] == 1)
                    break;
                // 해당 방향으로 이미 방문한 곳이라면
                if (visited[now.dir][rr][cc])
                    continue;

                visited[now.dir][rr][cc] = true;
                q.add(new Robot(rr, cc, now.dir, now.cnt + 1));
            }

            // 방향을 전환
            for (int d = 1; d < 4; d++) {
                int cnt = d != 3 ? d : 1;
                int ndir = (now.dir + d) % 4;

                // 해당 방향으로 이미 방문한 곳
                if (visited[ndir][now.r][now.c])
                    continue;

                visited[ndir][now.r][now.c] = true;
                q.add(new Robot(now.r, now.c, ndir, now.cnt + cnt));
            }
        }

        return -1;
    }

    static class Robot {
        int r, c, dir, cnt;

        public Robot(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
