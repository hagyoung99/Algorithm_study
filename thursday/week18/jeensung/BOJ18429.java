package jeensung;
import java.util.*;
public class BOJ18429 {
	static int n, k;
	static int[]arr;
	static boolean[] visit;
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		dfs(0, 500);
		System.out.print(answer);
	}
	static void dfs(int count, int sum) {
		if(count == n) {
			answer++;
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visit[i] && sum - k + arr[i] >= 500) {
				visit[i] = true;
				dfs(count + 1, sum - k + arr[i]);
				visit[i] = false;
			}
		}
	}
}
