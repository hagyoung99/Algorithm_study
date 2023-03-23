package jeensung;
import java.util.*;
public class BOJ9372 {
	static int n, m;
	static List<Integer>[] list;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			answer = Integer.MAX_VALUE;
			n = scan.nextInt();	
			m = scan.nextInt();
			list = new List[n + 1];
			for(int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				list[x].add(y);
				list[y].add(x);
			}
			System.out.println(n - 1);
		}
	}
}
