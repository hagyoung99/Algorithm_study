package jeensung;
import java.util.*;
public class BOJ2447 {
	static int n;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new char[n][n];
		dfs(0, 0, n, false);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	static void dfs(int x, int y, int n, boolean ok) {
		if(ok) {
			for(int i =x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		int size = n / 3;
		int count = 0;
		for(int i = x; i < x + n; i += size) {
			for(int j = y; j < y + n; j += size) {
				count++;
				if(count == 5) 
					dfs(i, j, size, true);
				else
					dfs(i, j, size, false);
			}
		}
	}
}
