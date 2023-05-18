package BOJ.boj1726;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N;
    static int[][] factory;
    static boolean[][][] visited;
    static int sX, sY, sDir, eX, eY, eDir;
    static int cnt = Integer.MAX_VALUE;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        factory = new int[M][N];
        visited = new boolean[M][N][4];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                factory[i][j] = sc.nextInt();
            }
        }

        sX = sc.nextInt() - 1;
        sY = sc.nextInt() - 1;
        sDir = sc.nextInt() - 1;
        eX = sc.nextInt() - 1;
        eY = sc.nextInt() - 1;
        eDir = sc.nextInt() - 1;

        visited[sX][sY][sDir] = true;

        bfs();

        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sX, sY, sDir, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == eX && cur[1] == eY && cur[2] == eDir) {
                cnt = Math.min(cnt, cur[3]);
            }

            for (int i = 1; i <= 3; i++) {
                int nx = cur[0] + direction[cur[2]][0] * i;
                int ny = cur[1] + direction[cur[2]][1] * i;
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (factory[nx][ny] == 1) break;
                if (!visited[nx][ny][cur[2]]) {
                    visited[nx][ny][cur[2]] = true;
                    q.add(new int[]{nx, ny, cur[2], cur[3] + 1});
                }
            }

            int left = 0;
            int right = 0;
            switch (cur[2]) {
                case 0: left = 3; right = 2; break;
                case 1: left = 2; right = 3; break;
                case 2: left = 0; right = 1; break;
                case 3: left = 1; right = 0; break;
            }

            if (!visited[cur[0]][cur[1]][left]) {
                visited[cur[0]][cur[1]][left] = true;
                q.add(new int[]{cur[0], cur[1], left, cur[3] + 1});
            }
            if (!visited[cur[0]][cur[1]][right]) {
                visited[cur[0]][cur[1]][right] = true;
                q.add(new int[]{cur[0], cur[1], right, cur[3] + 1});
            }
        }
    }
}
