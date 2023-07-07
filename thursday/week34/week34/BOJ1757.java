package week34;
import java.util.*;
public class BOJ1757 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = scan.nextInt();
		int[][] dp = new int[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			
			dp[i][0] = dp[i - 1][0];
			for(int j = 1; j <= m; j++)
				dp[i][j] = dp[i - 1][j - 1] + arr[i];
			
			for(int j = 1; j <= m && i > j; j++)
				dp[i][0] = Math.max(dp[i][0],  dp[i - j][j]);
		}
		System.out.println(dp[n][0]);
	}

}
