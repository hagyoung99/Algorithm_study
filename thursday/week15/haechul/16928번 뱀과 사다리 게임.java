package BOJ.boj16928;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static Queue<Point> q = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N + M; i++) {
            board[sc.nextInt()] = sc.nextInt();
        }
        cnt = 0;
        bfs(1, 0);
    }

    private static void bfs(int x, int cost) {
        q.add(new Point(x, cost));
        visited[x] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == 100) {
                System.out.println(cur.y);
                return;
            }
            if (board[cur.x] != 0) {
                cur.x = board[cur.x];
                visited[cur.x] = true;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = cur.x + i;
                if (nx > 0 && nx < 101) {
                    if (!visited[nx]) {
                        q.add(new Point(nx, cur.y + 1));
                        visited[nx] = true;
                    }
                }
            }
        }
    }
}
