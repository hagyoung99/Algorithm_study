package cod;
import java.util.*;
public class BOJ1495 {
	static int n, s, m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		s = scan.nextInt();
		m = scan.nextInt();
		int[] arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = scan.nextInt();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][s] = true;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(!dp[i - 1][j])
					continue;
				if(j + arr[i] <= m)
					dp[i][j + arr[i]] = true;
				if(j - arr[i] >= 0)
					dp[i][j - arr[i]] = true;
			}
		}
		for(int i = m; i>= 0; i--) {
			if(dp[n][i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

}
