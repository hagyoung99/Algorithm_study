package BOJ.boj14925;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] land = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                land[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[M + 1][N + 1];
        int max = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (land[i][j] > 0) {
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
