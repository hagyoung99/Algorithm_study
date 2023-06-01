package week29;
import java.util.*;
public class BOJ14925 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = scan.nextInt();
		int[][] ans = new int[m + 1][n + 1];
		int answer = 0;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(arr[i - 1][j - 1]== 0) {
					ans[i][j] = Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]) + 1;
					answer = Math.max(answer, ans[i][j]);
				}
			}
		}
		System.out.println(answer);
	}

}
