package week27;
import java.util.*;
class Algo{
	int x;
	int y; 
	int cost;
	Algo(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class BOJ1261 {
	static int n, m;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] ans;
	static int[][] arr;
	static boolean[][][] visit;
	static int answer = Integer.MAX_VALUE;
	static Queue<Algo> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		arr = new int[n][m];
		ans = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ans[i][j] = 10000000;
		ans[0][0] = 0;
		visit = new boolean[n][m][10001];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) 
				arr[i][j] = str.charAt(j) - '0';
		}
		queue.offer(new Algo(0, 0, 0));
		visit[0][0][0] = true;
		bfs();
		System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Algo now = queue.poll();
			if(now.x == n - 1 && now.y == m - 1) {
				answer = Math.min(answer, now.cost);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(arr[nx][ny] == 1) {
					if(ans[nx][ny] > now.cost + 1) {
						ans[nx][ny] = now.cost + 1;
						visit[nx][ny][now.cost + 1] = true;
						queue.offer(new Algo(nx, ny, now.cost + 1));
					}
				}else if(arr[nx][ny] == 0) {
					if(ans[nx][ny] > now.cost) {
						ans[nx][ny] = now.cost;
						visit[nx][ny][now.cost] = true;
						queue.offer(new Algo(nx, ny,now.cost));
					}
				}
			}
		}
	}
}
