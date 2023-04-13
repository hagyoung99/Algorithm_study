package b전체문제.실버.돌게임3_9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
            dp[3] = 1;
            dp[4] = 1;
        }

        for (int i = 5; i <= n; i++) {
            dp[i] = 2;
            if (dp[i - 1] % 2 == 0 || dp[i - 3] % 2 == 0 || dp[i - 4] % 2 == 0) {
                dp[i] = 1;
            }
        }

        if (dp[n] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
        
        

    }
}
