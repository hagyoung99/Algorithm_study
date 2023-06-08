package week30;

import java.util.*;
class Cow{
	int x;
	int y;
	int time;
	int limit;
	Cow(int x, int y, int time, int limit){
		this.x = x;
		this.y = y;
		this.time = time;
		this.limit = limit;
	}
}
public class BB {
	static int n, t;
	static int[][] arr;
	static int[][][] map;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int answer = Integer.MAX_VALUE;
	static PriorityQueue<Cow> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		t = scan.nextInt();
		arr = new int[n][n];
		map = new int[n][n][3];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				arr[i][j] = scan.nextInt();
				for(int k = 0; k < 3; k++)
					map[i][j][k] = 100000000;
			}
		map[0][0][0] = 0;
		queue.offer(new Cow(0, 0, 0, 0));
		dijkstra();
		System.out.println(map[2][2][0] + " " + map[2][2][1] + " " + map[2][2][2]);
		System.out.println(answer);
	}
	static void dijkstra() {
		while(!queue.isEmpty()) {
			Cow now = queue.poll();
			if(now.x == n - 1 && now.y == n - 1) {
				answer = Math.min(answer, now.time);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if((now.limit + 1) % 3 != 0) {
					if(map[nx][ny][(now.limit + 1) % 3] > now.time + t) {
						map[nx][ny][(now.limit + 1) % 3] = now.time + t;
						queue.offer(new Cow(nx, ny, map[nx][ny][(now.limit + 1) % 3], now.limit + 1));
					}
				}else {
					if(map[nx][ny][(now.limit + 1) % 3] > now.time + t + arr[nx][ny]) {
						map[nx][ny][(now.limit + 1) % 3] = now.time + t + arr[nx][ny];
						queue.offer(new Cow(nx, ny, map[nx][ny][(now.limit + 1) % 3], now.limit + 1));
					}
				}
			}
		}
	}
}
