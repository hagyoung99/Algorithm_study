package BOJ.boj7569;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[][] dir = {{-1, 0,  0}, {1, 0, 0}, {0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}};

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        q.add(new Point(i, j, k));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y][p.z] = true;
            for (int i = 0; i < dir.length; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                int nz = p.z + dir[i][2];

                if (nx >= 0 && ny >= 0 && nz >= 0 &&
                    nx < H && ny < N && nz < M && box[nx][ny][nz] == 0) {
                    q.add(new Point(nx, ny, nz));
                    visited[nx][ny][nz] = true;
                    box[nx][ny][nz] = box[p.x][p.y][p.z] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, box[i][j][k]);
                }
            }
        }
        System.out.println(max - 1);
    }
}
