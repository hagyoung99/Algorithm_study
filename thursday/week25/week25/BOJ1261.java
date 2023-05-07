package week25;
import java.util.*;
class Point{
	int x;
	int y;
	int count;
	Point(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
public class BOJ1261 {
	static int m, n;
	static PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> (o1.count - o2.count));
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		map = new int[n][m];
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) 
				arr[i][j] = str.charAt(j) - '0';
		}
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				map[i][j] = 1000000000;
		map[0][0] = 0;
		queue.offer(new Point(0, 0, 0));
		dijkstra();
		System.out.println(map[n - 1][m - 1]);
	}
	static void  dijkstra() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if(arr[nx][ny] == 1) {
					if(map[nx][ny] > 1 + map[now.x][now.y]) {
						map[nx][ny] = 1 + map[now.x][now.y];
						queue.offer(new Point(nx, ny, map[nx][ny]));					}
				}
				else if(arr[nx][ny] == 0) {
					if(map[nx][ny] > map[now.x][now.y]) {
						map[nx][ny] = map[now.x][now.y];
						queue.offer(new Point(nx, ny, map[nx][ny]));
					}
				}
			}
		}
	}
}
