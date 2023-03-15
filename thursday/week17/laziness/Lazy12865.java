import java.util.Scanner;

public class Lazy12865 {
    public static int[] weights = new int[101];
    public static int[] values = new int[101];
    public static int[][] dp = new int[101][100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        for(int i = 1 ; i <= n ; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j - weights[i] >= 0) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[n][k]);
        scanner.close();
    }
}
