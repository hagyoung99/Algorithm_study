import java.util.Scanner;
public class BOJ15650 {
	public static int[] arr;
	public static int N, M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[M];
		dfs(1, 0);
	}
	public static void dfs(int t, int depth) {
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for (int i = t; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
}