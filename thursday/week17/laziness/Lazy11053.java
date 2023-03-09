import java.util.*;

public class Lazy11053 {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        dp = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextInt();
        for(int i = 0 ; i < n ; i++) fillDp(i);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
        scanner.close();
    }
    public static int fillDp(int n) {
        if (dp[n] == 0) {
            dp[n] = 1;
            for (int i = n - 1; i > -1; i--) {
                if(arr[i] < arr[n]) dp[n] = Math.max(dp[n], fillDp(i) + 1);
            }
        }
        return dp[n];
    }
}