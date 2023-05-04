package thursday.week25.jinu;

import java.io.*;
import java.util.*;

public class BOJ3184 {

    static int R, C;
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };;
    static char[][] map;
    static boolean[][] visit;
    static int sheepTotal = 0, wolfTotal = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheepTotal + " " + wolfTotal);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[] { x, y });
        int sheepCnt = 0, wolfCnt = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == 'o') {
                sheepCnt++;
            } else if (map[now[0]][now[1]] == 'v') {
                wolfCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i], ny = now[1] + dy[i];

                if (!isRange(nx, ny) || visit[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }

                visit[nx][ny] = true;
                q.add(new int[] { nx, ny });
            }
        }

        if (sheepCnt > wolfCnt) {
            sheepTotal += sheepCnt;
        } else {
            wolfTotal += wolfCnt;
        }
    }

    static boolean isRange(int x, int y) {
        return x > 0 && x < R && y >= 0 && y < C;
    }

}
