package BOJ.boj1495;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            int volume = sc.nextInt();
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = false;
                    if (j + volume <= M) {
                        dp[i][j + volume] = true;
                    }
                    if (j - volume >= 0) {
                        dp[i][j - volume] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
