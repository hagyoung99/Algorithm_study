package week32;
import java.util.*;
public class BOJ6443 {
	static int n;
	static char[] a ,arr, ans;
	static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			a = str.toCharArray();
			arr = new char[str.length()];
			ans = new char[str.length()];
			visit = new boolean[str.length()];
			Arrays.sort(a);
			dfs(0, str.length());
		}
	}
	static void dfs(int count, int end) {
		if(count == end) {
			System.out.println(arr);
			return;
		}
		ans[count] = 0;
		for(int i = 0; i < end; i++) {
			if(!visit[i] && ans[count] < a[i]) {
				ans[count] = a[i];
				visit[i] = true;
				arr[count] = a[i];
				dfs(count + 1, end);
				visit[i] = false;
			}
		}
	}
}
