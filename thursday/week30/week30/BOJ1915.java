package week30;
import java.util.*;
public class BOJ1915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] dp = new int[n + 1][m + 1];
		long max = 0;
		for(int i = 1; i <= n; i++) {
			String str = scan.next();
			for(int j = 1; j <= m; j++) {
				if(str.charAt(j - 1) - '0' == 0) continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max * max);
	}

}
