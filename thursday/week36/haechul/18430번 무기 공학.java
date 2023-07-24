package BOJ.boj18430;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] tree;
    static int max = 0;
    static boolean[][] v;
    static int[][] dir = {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        tree = new int[n][m];
        v = new boolean[n][m];
        if (n < 2 || m < 2) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tree[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int result) {
        if (idx == n * m) {
            max = Math.max(result, max);
            return;
        }

        int i = idx / m;
        int j = idx % m;

        if (!v[i][j]) {
            for (int k = 0; k < 4; k++) {
                int nx = i + dir[k][0];
                int ny = j + dir[k][1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !v[i][j] && !v[nx][j] && !v[i][ny]) {
                    int sum = (tree[i][j] * 2) + tree[nx][j] + tree[i][ny];
                    v[i][j] = v[nx][j] = v[i][ny] = true;
                    dfs(idx + 1, result + sum);
                    v[i][j] = v[nx][j] = v[i][ny] = false;
                }
            }
        }
        dfs(idx + 1, result);
    }
}
