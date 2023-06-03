package BOJ.boj1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        int[][] dp = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = arr[0][i];
            max = Math.max(dp[0][i], max);
        }

        if (n < 2 || m < 2) {
            System.out.println(max * max);
            System.exit(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        System.out.println(max * max);
    }
}
