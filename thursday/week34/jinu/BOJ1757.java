package thursday.week34.jinu;

import java.io.*;
import java.util.*;

public class BOJ1757 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int[] psum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            for (int j = 1; j <= M && i + 2 * j <= N + 1; j++) {
                dp[i + 2 * j] = Math.max(dp[i + 2 * j], dp[i] + psum[i + j - 1] - psum[i - 1]);
            }
        }

        System.out.println(dp[N + 1]);

    }

}
