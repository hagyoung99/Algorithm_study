package week33;
import java.util.*;
class King{
	int x;
	int y;
	int cost;
	King(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class BOJ16509 {
	static int r1, c1, r2, c2;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] d = {{-2, -2}, {-2, 2}, {2, -2}, {2, 2}, {-2, 2}, {2, 2}, {-2, -2}, {2, -2}};
	static boolean[][] visit = new boolean[10][9];
	static Queue<King> queue = new LinkedList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		r1 = scan.nextInt();
		c1 = scan.nextInt();
		r2 = scan.nextInt();
		c2 = scan.nextInt();
		visit[r1][c1] = true;
		queue.offer(new King(r1, c1, 0));
		bfs();
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			King now = queue.poll();
			if(now.x == r2 && now.y == c2)
				answer = Math.min(answer, now.cost);
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1];
				if(nx < 0 || ny < 0 || nx >= 10 || ny >= 9) continue;
				if(nx == r2 && ny == c2) continue;
				for(int j = 0; j < 2; j++) {
					int tx = nx + d[(i * 2) + j][0];
					int ty = ny + d[(i * 2) + j][1];
					if(tx < 0 || ty < 0 || tx >= 10 || ty >= 9) continue;
					if(visit[tx][ty]) continue;
					int ttx = tx - (d[(i * 2) + j][0] / 2);
					int tty = ty - (d[(i * 2) + j][1] / 2);
					if(ttx == r2 && tty == c2) continue;
					visit[tx][ty] = true;
					queue.offer(new King(tx, ty, now.cost + 1));
				}
			}
		}
	}
}
