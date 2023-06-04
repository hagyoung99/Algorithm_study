package BOJ.boj14938;

import java.util.Scanner;

public class Main {
    static int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        int[] items = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w  = sc.nextInt();
            dist[x][y] = w;
            dist[y][x] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    sum += items[j];
                }
            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
