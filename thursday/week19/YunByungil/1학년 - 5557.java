package 전체문제.골드.학년1_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, sum;
    public static int[] arr;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new long[n - 1][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] != 0) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];

                    if (0 <= plus && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }

                    if(0 <= minus && minus <= 20){
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
        System.out.println("(n - 2) = " + (n - 2));
        System.out.println("arr[n - 1] = " + arr[n - 1]);

    }
}
