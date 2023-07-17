package BOJ.boj18427;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int[][] dp = new int[n + 1][h + 1];

        sc.nextLine();

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            list[i] = new ArrayList<>();
            for (int j = 0; j < tmp.length; j++) {
                list[i].add(Integer.parseInt(tmp[j]));
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (int x : list[i]) {
                    if (j >= x) {
                        dp[i][j] += dp[i - 1][j - x];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[n][h]);
    }
}
