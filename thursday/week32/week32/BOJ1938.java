package week32;
import java.util.*;
class Tong{
	int x1;
	int y1;
	int x2;
	int y2;
	int cost;
	boolean dd;
	Tong(int x1, int y1){
		this.x1 = x1;
		this.y1 = y1;
	}
	Tong(int x1, int y1, int x2, int y2, boolean dd, int cost){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.dd = dd;
		this.cost = cost;
	}
}
public class BOJ1938 {
	static int n;
	static boolean[][][][]visit;
	static char[][] arr;
	static Queue<Tong> queue = new LinkedList<>();
	static int t = Integer.MAX_VALUE;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {0, 0}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new char[n][n];
		visit = new boolean[n][n][n][n];
		List<Tong> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				if(str.charAt(j) == 'B') 
					list.add(new Tong(i, j));
			}
		}
		if(list.get(0).x1 == list.get(2).x1) // 가로 
			queue.offer(new Tong(list.get(0).x1, list.get(0).y1,list.get(2).x1, list.get(2).y1, true, 0));
		else //세로
			queue.offer(new Tong(list.get(0).x1, list.get(0).y1,list.get(2).x1, list.get(2).y1, false, 0));
		Tong now = queue.peek();
		visit[now.x1][now.y1][now.x2][now.y2] = visit[now.x2][now.y2][now.x1][now.y1] = true;
		bfs();
		if(t == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(t);
		scan.close();
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Tong now = queue.poll();
			if(arr[now.x1][now.y1] == 'E' && arr[now.x2][now.y2] == 'E') {
				t = Math.min(t, now.cost);
				continue;
			}
			for(int i = 0; i < 5; i++) {
				if(i < 4) {
					int nx1 = now.x1 + dir[i][0];
					int ny1 = now.y1 + dir[i][1];
					int nx3 = now.x2 + dir[i][0];
					int ny3 = now.y2 + dir[i][1];
					int nx2 = (nx1 + nx3) / 2;
					int ny2 = (ny1 + ny3) / 2;
					if(nx1 < 0 || ny1 < 0 || nx3 < 0 || ny3 < 0 ||
							nx1 >= n || ny1 >= n || nx3 >= n || ny3 >= n)
						continue;
					if(arr[nx1][ny1] == '1' || arr[nx2][ny2] == '1' || arr[nx3][ny3] == '1')
						continue;
					if(visit[nx1][ny1][nx3][ny3] || visit[nx3][ny3][nx1][ny1])
						continue;
					visit[nx1][ny1][nx3][ny3] = true;
					visit[nx3][ny3][nx1][ny1] = true;
					queue.offer(new Tong(nx1, ny1, nx3, ny3, now.dd, now.cost + 1));
				}else {
					if(now.dd) {//가로면 세로로 변경
						int ny2;
						int nx1;
						int nx3;
						if(now.y1 < now.y2) {
							ny2 = (now.y1 + now.y2) / 2;
							nx1 = now.x1 + 1;
							nx3 = now.x1 - 1;
							if(nx1 >= n || nx3 < 0)
								continue;
							boolean isOk = false;
							for(int a = nx3; a <= nx1; a++) {
								for(int b = now.y1; b <= now.y2; b++) {
									if(arr[a][b] == '1') {
										isOk = true;
										break;
									}
								}
								if(isOk) break;
							}
							if(isOk) continue;
						}else {
							ny2 = (now.y1 + now.y2)/ 2;
							nx1 = now.x1 - 1;
							nx3 = now.x1 + 1;
							if(nx1 < 0 || nx3 >= n)
								continue;
							boolean isOk = false;
							for(int a = nx1; a <= nx3; a++) {
								for(int b = now.y2; b <= now.y1; b++) {
									if(arr[a][b] == '1') {
										isOk = true;
										break;
									}
								}
								if(isOk) break;
							}
							if(isOk) continue;
						}

						if(visit[nx1][ny2][nx3][ny2] || visit[nx3][ny2][nx1][ny2])
							continue;
						visit[nx1][ny2][nx3][ny2] = true;
						visit[nx3][ny2][nx1][ny2] = true;
						queue.offer(new Tong(nx1, ny2, nx3, ny2, !now.dd, now.cost + 1));
					}else {//세로를 가로
						int nx2;
						int ny1;
						int ny3;
						if(now.x1 < now.x2) {
							nx2 = (now.x1 + now.x2) / 2;
							ny1 = now.y1 - 1;
							ny3 = now.y1 + 1;
							if(ny1 < 0 || ny3 >= n)
								continue;
							boolean isOk = false;
							for(int a = now.x1; a <= now.x2; a++) {
								for(int b = ny1; b <= ny3; b++) {
									if(arr[a][b] == '1') {
										isOk = true;
										break;
									}
								}
								if(isOk) break;
							}
							if(isOk) continue;
						}else {
							nx2 = (now.x1 + now.x2) / 2;
							ny1 = now.y1 + 1;
							ny3 = now.y1 - 1;
							if(ny3 < 0 || ny1 >= n)
								continue;
							boolean isOk = false;
							for(int a = now.x2; a <= now.x1; a++) {
								for(int b = ny3; b <= ny1; b++) {
									if(arr[a][b] == '1') {
										isOk = true;
										break;
									}
								}
								if(isOk) break;
							}
							if(isOk) continue;
						}
						if(visit[nx2][ny1][nx2][ny3] || visit[nx2][ny3][nx2][ny1])
							continue;
						visit[nx2][ny1][nx2][ny3] = true;
						visit[nx2][ny3][nx2][ny1] = true;
						queue.offer(new Tong(nx2, ny1, nx2, ny3, !now.dd, now.cost + 1));
					}
				}
			}
		}
	}
}