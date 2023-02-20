package BOJ.boj2206;

import java.util.*;
import java.io.*;

public class Main {

    static class Point{
        int x, y, crashed;

        public Point(int x, int y, int crashed) {
            this.x = x;
            this.y = y;
            this.crashed = crashed;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        sc.nextLine();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Point> q = new LinkedList<>();
        int[][][] visited = new int[2][n][m];
        q.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;
        int nx, ny;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(visited[cur.crashed][cur.x][cur.y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = cur.x + dir[i][0];
                ny = cur.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (cur.crashed == 0 && visited[1][nx][ny] == 0) {
                        visited[1][nx][ny] = visited[cur.crashed][cur.x][cur.y] + 1;
                        q.offer(new Point(nx, ny, cur.crashed + 1));
                    }
                } else {
                    if (visited[cur.crashed][nx][ny] == 0) {
                        visited[cur.crashed][nx][ny] = visited[cur.crashed][cur.x][cur.y] + 1;
                        q.offer(new Point(nx, ny, cur.crashed));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
