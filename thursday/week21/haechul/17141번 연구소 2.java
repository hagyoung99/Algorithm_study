package BOJ.boj17141;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] map;
    static int xpos[] = {1, -1, 0, 0};
    static int ypos[] = {0, 0, 1, -1};
    static boolean[][] check;
    static boolean vis[];
    static ArrayList<Point> list = new ArrayList<>();
    static Queue<Point> q;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) map[i][j] = -1;
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                    map[i][j] = 0;
                }
            }
        }

        vis = new boolean[list.size()];
        comb(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void comb(int cnt, int start) {
        if (cnt == m) {
            bfs();
            return;
        }
        for (int i = start; i < list.size(); i++) {
            if (vis[i]) continue;
            vis[i] = true;
            comb(cnt + 1, i + 1);
            vis[i] = false;
        }

    }

    private static void bfs() {
        int[][] temp = copy();
        int cnt = 0;
        int time = 1;
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                if (temp[y][x] > cnt) cnt = temp[y][x];
                for (int k = 0; k < 4; k++) {
                    int yy = y + ypos[k];
                    int xx = x + xpos[k];
                    if (yy < 0 || xx < 0 || yy >= n || xx >= n) continue;
                    if (check[yy][xx]) continue;
                    if (temp[yy][xx] == 0) {
                        check[yy][xx] = true;
                        temp[yy][xx] = time;
                        q.add(new Point(yy, xx));
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] == 0) return;
            }
        }
        if (answer > cnt) answer = cnt;
    }

    private static int[][] copy() {
        q = new LinkedList<Point>();
        check = new boolean[n][n];
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (vis[i]) {
                int y = list.get(i).y;
                int x = list.get(i).x;
                c[y][x] = -2;
                q.add(new Point(y, x));
                check[y][x] = true;
            }
        }
        return c;
    }
}
