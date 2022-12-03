package jeensung;
import java.util.*;
public class BOJ10872 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n == 0) System.out.print(1);
		else {
			dfs(n, n);
		}
	}
	static void dfs(int n, long sum) {
		if(n == 1) {
			System.out.print(sum);
		}else {
			dfs(n - 1, sum * (n - 1));
		}
	}

}
