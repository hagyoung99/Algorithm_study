package BOJ.boj4811;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            long[] dp = new long[31];

            dp[0] = 1;

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
