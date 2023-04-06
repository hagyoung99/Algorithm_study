package jeensung;
import java.util.*;
public class BOJ9657 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[] dp = new boolean[n + 1];
		dp[1] = dp[3] = dp[4] = true;
		for(int i = 5; i <= n; i++) {
			if(dp[i - 1] && dp[i - 3] && dp[i - 4])
				dp[i] = false;
			else
				dp[i] = true;
		}
		if(dp[n])
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}
