package jeensung;
import java.util.*;
public class BOJ11729 {
	static int n;
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		dfs(n, 1, 3, 2);
		scan.close();
		System.out.println(count);
		System.out.println(sb);
	}
	static void dfs(int n, int from, int to, int x) {
		if(n == 0)return;
		count++;
		dfs(n - 1, from, x, to);
		sb.append(from + " " + to + "\n");
		dfs(n - 1, x, to, from);
	}
}
