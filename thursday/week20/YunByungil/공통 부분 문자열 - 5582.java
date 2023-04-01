package b전체문제.골드.공통부분문자열_5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReMain {
    public static char[] str1;
    public static char[] str2;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        int l1 = str1.length;
        int l2 = str2.length;

        dp = new int[l1 + 1][l2 + 1];

        int max = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}
