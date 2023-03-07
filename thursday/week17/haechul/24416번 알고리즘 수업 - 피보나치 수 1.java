package BOJ.boj24416;

import java.util.Scanner;

public class Main {
    public static int recursionCnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fib(n);
        System.out.println(recursionCnt);
        System.out.println(fibonacci(n));

    }

    private static int fib(int n) {
        if (n == 1 | n == 2) {
            return 1;
        }
        recursionCnt++;
        return (fib(n - 1) + fib(n - 2));
    }

    private static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        int cnt = 0;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            cnt++;
        }

        return cnt;
    }
}
