package jeensung;
import java.util.*;
public class BOJ24416 {
	static int count1 = 0;
	static int count2 = 0;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		fib(n);
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			count2++;
		}
		System.out.println(count1 + " " + count2);
	}
	static int fib(int x) {
		if(x == 1 || x == 2) {
			count1++;
			return 1;
		}
		return(fib(x - 1) + fib(x - 2));
	}
}
