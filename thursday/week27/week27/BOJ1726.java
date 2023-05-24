package week27;
import java.util.*;
class Robot{
	int x;
	int y;
	int dir;
	int cost;
	Robot(int x, int y, int d, int cost){
		this.x = x;
		this.y = y;
		this.dir = d;
		this.cost = cost;
	}
}
public class BOJ1726 {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[] ans = new int[4];
	static int n, m;
	static int[][] arr;
	static boolean[][][] visit;
	static int x, y, d;
	static int X, Y, D;
	static int answer = Integer.MAX_VALUE;
	static Queue<Robot> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		visit = new boolean[n][m][4];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				arr[i][j] = scan.nextInt();
		ans[0] = 0;
		ans[1] = 2;
		ans[2] = 1;	
		ans[3] = 3;
		x = scan.nextInt() - 1;
		y = scan.nextInt() - 1;
		d = scan.nextInt() - 1;
		X = scan.nextInt() - 1;
		Y = scan.nextInt() - 1;
		D = scan.nextInt() - 1;
		queue.offer(new Robot(x, y, ans[d], 0));
		visit[x][y][ans[d]] = true;
		bfs();
		System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Robot now = queue.poll();
			if(now.x == X && now.y == Y && now.dir == ans[D]) {
				answer = Math.min(answer, now.cost);
				continue;
			}
			for(int i = 0; i < 2; i++) {
				int nx; int ny;
				int t;
				if(i == 1) {
					for(int j = -1; j <= 1; j++) {
						if(j == -1) {
							t = (now.dir + j + 4) % 4; 
							if(visit[now.x][now.y][t])
								continue;
							visit[now.x][now.y][t] = true;
							queue.offer(new Robot(now.x, now.y, t, now.cost + 1));
						}else if(j == 1) {
							t = (now.dir + j + 4) % 4;
							if(visit[now.x][now.y][t])continue;
							visit[now.x][now.y][t] = true;
							queue.offer(new Robot(now.x, now.y, t, now.cost + 1));
						}
					}
				}else {
					for(int j = 1; j <= 3; j++) {
						nx = now.x + (dir[now.dir][0] * j);
						ny = now.y + (dir[now.dir][1] * j);
						if(nx < 0 || ny < 0 || nx >= n || ny >= m)
							break;
						if(arr[nx][ny] == 1)
							break;
						if(visit[nx][ny][now.dir])
							continue;
						visit[nx][ny][now.dir] = true;
						queue.offer(new Robot(nx, ny, now.dir, now.cost  + 1));
					}
				}
			}
		}
	}
}
