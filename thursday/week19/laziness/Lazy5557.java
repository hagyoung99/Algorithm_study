package thursday.week19.laziness;

import java.util.*;

public class Lazy5557 {
    public static List<Integer> accumulator = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n - 1][21];
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextInt();
        
        dp[0][arr[0]] = 1;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] != 0) {
					if(j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j];					
					if(j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j];					
				}
			}
		}
		System.out.println(dp[n - 2][arr[n - 1]]);
        scanner.close();
    }
}