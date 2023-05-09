package week26;
import java.awt.Point;
import java.util.*;
public class BOJ1941 {
	static int answer = 0;
	static char[][] arr = new char[5][5];
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[] visit = new boolean[25];
	static boolean[][] visit2 = new boolean[5][5];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			String str = scan.next();
			for(int j = 0; j < 5; j++)
				arr[i][j] = str.charAt(j);
		}	
		dfs(0, 7, 0, 0);
		System.out.println(answer);
	}
	static void dfs(int count, int end, int m, int S) {
		if(count == end) {
			if(S < 4)
				return;
			if(check())
				answer++;
			return;
		}
		for(int i = m; i < 25; i++) {
			int nx = i / 5;
			int ny = i % 5;
			if(!visit[i]) {
				visit[i] = true;
				if(arr[nx][ny] == 'S')
					dfs(count + 1, end, i, S + 1);
				else
					dfs(count + 1, end, i, S);
				visit[i] = false;
			}
		}
	}
	static boolean check() {
		boolean[][] visit2 = new boolean[5][5];
		int x = 0;
		int y = 0;
		for(int i = 0; i < 25; i++) {
			if(visit[i]) {
				x = i / 5;
				y = i % 5;
				break;
			}
		}
		int count = 1;
		visit2[x][y] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
					continue;
				if(visit2[nx][ny])
					continue;
				if(visit[nx * 5 + ny]) {
					count++;
					queue.offer(new Point(nx, ny));
					visit2[nx][ny] = true;
				}
			}
		}
		if(count == 7)
			return true;
		return false;
	}
}
