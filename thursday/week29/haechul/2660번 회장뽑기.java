package BOJ.boj2660;

import java.util.Scanner;

public class Main {
    static final int INF = 100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == -1 && y == -1) {
                break;
            }
            dist[x][y] = dist[y][x] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            // i -> j (k를 거쳐서 가는 경우가 짧으면 업데이트)
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] score = new int[n + 1];
        int min = INF;
        for (int i = 1; i < n + 1; i++) {
            int max = 0;
            for (int j = 1; j < n + 1; j++) {
                max = Math.max(dist[i][j], max);
            }
            score[i] = max;
            min = Math.min(score[i], min);
        }
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (int i = 1; i < score.length; i++) {
            if (score[i] == min) {
                cnt++;
                sb.append(i + " ");
            }
        }
        System.out.println(min + " " + cnt);
        System.out.println(sb);
    }
}
