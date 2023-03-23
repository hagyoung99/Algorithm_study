package jeensung;
import java.awt.Point;
import java.util.*;
public class BOJ1303 {
	static int n, m;
	static char[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new char[m][n];
		visit = new boolean[m][n];
		int x = 0;
		int y = 0;
		for(int i = 0; i < m; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++)
				arr[i][j] = str.charAt(j);
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					if(arr[i][j] == 'W') {
						x += (int)Math.pow(dfs(i, j, 'W'), 2);
					}else {
						y += (int)Math.pow(dfs(i, j, 'B'), 2);
					}
				}
			}
		}
		System.out.println(x + " " + y);
	}
	static int dfs(int x, int y, char t) {
		int count = 1;
		visit[x][y] = true;
		Queue<Point> queue = new LinkedList<>();
		int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		queue.offer(new Point(x, y));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if(visit[nx][ny])
					continue;
				if(arr[nx][ny] == t) {
					visit[nx][ny] = true;
					queue.offer(new Point(nx, ny));
					count++;
				}
			}
		}
		return count;
	}
}
