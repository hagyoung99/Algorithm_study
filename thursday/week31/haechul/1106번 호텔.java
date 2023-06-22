package BOJ.boj1106;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int n = sc.nextInt();

        int[] dp = new int[c + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            int people = sc.nextInt();

            for (int j = people; j < c + 100; j++) {
                if (dp[j - people] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - people]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = c; i < c + 100; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
