package week25;
import java.util.*;
public class BOJ1535{
	static int[] hp = new int[21];
	static int[] up = new int[21];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int ans = 0;
	    int[][] dp = new int[21][101];
	    for (int i = 1; i <= n; i++) 
	        hp[i] = scan.nextInt();
	    for (int i = 1; i <= n; i++) 
	        up[i] = scan.nextInt();
	    dp[1][100 - hp[1]] = up[1];	 
	    for (int i = 2; i <= n; i++) {
	        dp[i][100 - hp[i]] = up[i];
	        for (int j = 100; j > 0; j--) {
	            if (j + hp[i] <= 100 && dp[i - 1][j + hp[i]] != 0) 
	                dp[i][j] = Math.max(dp[i - 1][j + hp[i]] + up[i], dp[i - 1][j]);
            	else 
	                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
	        }
	    }
	 
	    for (int i = 100; i > 0; i--) 
	        ans = Math.max(dp[n][i], ans);
	    System.out.println(ans);
	}
}
