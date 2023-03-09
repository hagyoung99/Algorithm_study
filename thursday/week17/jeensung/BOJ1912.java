package jeensung;
import java.util.*;
public class BOJ1912{
	public static int[] arr;
	public static Integer[] dp;
	public static int max;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		dp = new Integer[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		
		dp[0] = arr[0];
		max = arr[0];
		
		sum(n-1);
		System.out.println(max);
	}
	public static int sum(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(sum(n-1) + arr[n], arr[n]);
			max = Math.max(dp[n],  max);
		}
		return dp[n];
	}
}