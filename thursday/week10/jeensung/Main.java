package samsung01.jeensung;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		int[] ans = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		for(int i = 0; i < n; i++)
			ans[i] = scan.nextInt();
		int[][] dp = new int[n][10001];
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int memory = arr[i];
			int cost = ans[i];
			for(int j = 0; j <= 10000; j++) {
				if(i == 0) {
					if(j >= cost)
						dp[i][j] = memory;
				}
				else {
					if(j >= cost)
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				}
				if(dp[i][j] >= m)
					answer = Math.min(answer, j);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= 15; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(answer);
	}

}
