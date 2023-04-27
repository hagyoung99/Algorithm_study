package week24;
import java.util.*;
public class BOJ13305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] arr = new long[n - 1];
		for(int i = 0; i < n - 1; i++)
			arr[i] = scan.nextLong();
		long[] ans = new long[n];
		for(int i = 0; i < n; i++)
			ans[i] = scan.nextLong();
		long answer = 0;
		long min = ans[0];
		for(int i = 0; i < n - 1; i++) {
			if(ans[i] < min)
				min = ans[i];
			answer += min * arr[i];
		}
		System.out.println(answer);
	}

}
