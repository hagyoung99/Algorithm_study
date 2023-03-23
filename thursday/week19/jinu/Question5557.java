package thursday.week19.jinu;

import java.io.*;

public class Question5557 {
    static int n;
    static long dp[][];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] t = br.readLine().split(" ");

        dp = new long[n + 1][21];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(t[i - 1]);
        }
        dp[1][arr[1]] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j + arr[i] <= 20) {
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    }
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 1][arr[n]]);

    }
}