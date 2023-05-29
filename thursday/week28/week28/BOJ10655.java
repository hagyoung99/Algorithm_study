package week28;
import java.util.*;
public class BOJ10655 {
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		int[] ans = new int[n - 1];
		int answer = 0;
		for(int i = 0; i < n - 1; i++) {
			ans[i] = Math.abs(arr[i][0] - arr[i + 1][0]) + Math.abs(arr[i][1] - arr[i + 1][1]);
			answer += ans[i];
		}
		int max = 0;
		for(int i = 0; i < n - 2; i++) {
			int temp = Math.abs(arr[i][0] - arr[i + 2][0]) + Math.abs(arr[i][1] - arr[i + 2][1]);
			max = Math.max(max, ans[i] + ans[i + 1] - temp);
		}
		System.out.println(answer - max);
	}
}
