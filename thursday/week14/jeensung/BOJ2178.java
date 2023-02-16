<<<<<<< HEAD
import java.awt.Point;
import java.util.*;
public class BOJ2178 {
	static int n, m;
	static int[][] arr;
	static int[][] dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		for(int i = 0; i <n; i++)
			for(int j = 0; j <m; j++)
				dp[i][j] = 10000000;
		dp[0][0] = 1;
		dfs();
		System.out.println(dp[n - 1][m - 1]);
	}
	static void dfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(arr[nx][ny] == 0)
					continue;
				if(dp[nx][ny] > dp[now.x][now.y] + 1) {
					dp[nx][ny] = dp[now.x][now.y] +  1; 
					queue.offer(new Point(nx, ny));
				}
			}
		}
	}
}
=======
import java.awt.Point;
import java.util.*;
public class BOJ2178 {
	static int n, m;
	static int[][] arr;
	static int[][] dp;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		for(int i = 0; i <n; i++)
			for(int j = 0; j <m; j++)
				dp[i][j] = 10000000;
		dp[0][0] = 1;
		dfs();
		System.out.println(dp[n - 1][m - 1]);
	}
	static void dfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(arr[nx][ny] == 0)
					continue;
				if(dp[nx][ny] > dp[now.x][now.y] + 1) {
					dp[nx][ny] = dp[now.x][now.y] +  1; 
					queue.offer(new Point(nx, ny));
				}
			}
		}
	}
}
>>>>>>> 6d77b77b9ac776c10f060828fa803a090e52770f
