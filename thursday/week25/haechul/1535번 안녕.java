package BOJ.boj1535;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] health = new int[n + 1];
        int[] happy = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            health[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            happy[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][100];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 99; j++) {
                if (health[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - health[i]] + happy[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}
