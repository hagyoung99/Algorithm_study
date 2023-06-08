package week30;
import java.util.*;
public class BOJ2096 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n][3];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < 3; j++)
				arr[i][j] = scan.nextInt();
		int[][] max = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i = 0; i < 3; i++) {
			dp[0][i] = arr[0][i];
			max[0][i] = arr[0][i];
		}
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) { 
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
					max[i][j] = Math.max(max[i - 1][j], max[i - 1][j + 1]) + arr[i][j];
				}else if(j == 1) {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1])) + arr[i][j];
					max[i][j] = Math.max(max[i - 1][j], Math.max(max[i - 1][j + 1], max[i - 1][j - 1])) + arr[i][j];
				}else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
					max[i][j] = Math.max(max[i - 1][j], max[i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int answer = Integer.MIN_VALUE;
		for(int i = 0; i < 3; i++) {
			min = Math.min(dp[n - 1][i], min);
			answer = Math.max(max[n - 1][i], answer);
		}
		System.out.println(answer + " " + min);
	}

}
