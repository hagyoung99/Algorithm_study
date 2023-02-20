package BOJ.boj7562;

import java.util.*;

public class Main {
    static int l, sx, sy, ex, ey;
    static int[][] chess;
    static boolean[][] visited;
    static Queue<Point> q;
    static int[][] dir = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2},
                          {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            l = sc.nextInt();
            chess = new int[l][l];
            visited = new boolean[l][l];
            sx = sc.nextInt(); sy = sc.nextInt();
            ex = sc.nextInt(); ey = sc.nextInt();
            bfs();
        }
    }
    private static void bfs() {
        q = new LinkedList<>();
        q.add(new Point(sx, sy, 0));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == ex && p.y == ey) {
                System.out.println(p.cost);
                return;
            }
            for (int i = 0; i < dir.length; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, p.cost + 1));
                }
            }

        }
    }
}
