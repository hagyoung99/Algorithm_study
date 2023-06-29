package thursday.week33.jinu;

import java.util.Scanner;

public class BOJ2344 {

    static int n, m;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int[][] arr;
    static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        int count = 2 * (n + m);
        int start = 0;
        while (start < count) {
            if (start < n) {
                int nx = start;
                int ny = 0;
                if (arr[nx][ny] == 1)
                    dfs(nx, ny, 2);
                else
                    dfs(nx, ny, 1);
                System.out.print(t + " ");
            } else if (start >= n && start < n + m) {
                int nx = n - 1;
                int ny = start - n;
                if (arr[nx][ny] == 1)
                    dfs(nx, ny, 1);
                else
                    dfs(nx, ny, 2);
                System.out.print(t + " ");
            } else if (start >= n + m && start < 2 * n + m) {
                int nx = n + n + m - start - 1;
                int ny = m - 1;
                if (arr[nx][ny] == 1)
                    dfs(nx, ny, 0);
                else
                    dfs(nx, ny, 3);
                System.out.print(t + " ");
            } else {
                int nx = 0;
                int ny = n + n + m + m - start - 1;
                if (arr[nx][ny] == 1)
                    dfs(nx, ny, 3);
                else
                    dfs(nx, ny, 0);
                System.out.print(t + " ");
            }
            start++;
        }

        sc.close();
    }

    static void dfs(int nx, int ny, int d) {
        int tx = nx + dir[d][0];
        int ty = ny + dir[d][1];
        if (ty >= m) {
            t = n + m + n - tx;
            return;
        }
        if (tx >= n) {
            t = n + ty + 1;
            return;
        }
        if (ty < 0) {
            t = tx + 1;
            return;
        }
        if (tx < 0) {
            t = n + n + m + (m - ty);
            return;
        }
        if (arr[tx][ty] == 1) {
            if (d == 1)
                dfs(tx, ty, 2);
            else if (d == 0)
                dfs(tx, ty, 3);
            else if (d == 2)
                dfs(tx, ty, 1);
            else
                dfs(tx, ty, 0);
        } else
            dfs(tx, ty, d);
    }

}
