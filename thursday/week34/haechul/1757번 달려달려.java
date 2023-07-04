package BOJ.boj1757;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 운동 시간
        int m = sc.nextInt(); // 지침계수

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            // i번째에 쉬었을 경우
            dp[i][0] = dp[i - 1][0];
            // i번째에 달렸을 경우
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1] + arr[i];
            }
            // 지침지수가 0으로 끝나는 경우의 최댓값을 저장
            for (int j = 1; j <= m && i > j; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - j][j]);
            }
        }

        System.out.println(dp[n][0]);
    }
}
