package thursday.week25.jinu;

import java.util.*;
import java.io.*;

public class BOJ1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = 99;
        int[][] dp = new int[n + 1][k + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.print(dp[n][k]);
    }

}
