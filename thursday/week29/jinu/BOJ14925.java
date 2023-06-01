package thursday.week29.jinu;

import java.io.*;

public class BOJ14925 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int max = 0;
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(input[j - 1]) == 0) {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(Math.min(Math.min(min, dp[i - 1][j]), dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    if (max < dp[i][j])
                        max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }

}
