package BOJ.boj1189;

import java.util.*;

public class Main {
    static int R, C, K;
    static int cnt = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(cnt);

    }

    private static void dfs(int x, int y, int dist) {
        if (x == 0 && y == C - 1 && dist == K) {
            cnt++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        }
    }


}
