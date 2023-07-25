package BOJ.boj17086;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static boolean[][] v;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    static class Node {
        int x;
        int y;
        int c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        v = new boolean[n][m];
        v[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.x][cur.y] == 1) {
                return cur.c;
            }

            for (int i = 0; i < dir.length; i++) {
                int nx = cur.x + dir[i][0];
                int ny = cur.y + dir[i][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !v[nx][ny]) {
                    q.add(new Node(nx, ny, cur.c + 1));
                    v[nx][ny] = true;
                }
            }
        }

        return 0;
    }
}
