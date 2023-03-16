package jeensung;
import java.awt.Point;
import java.util.*;
public class BOJ2933 {
	static int r, c;
	static char[][] arr;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		arr = new char[r][c];
		for(int i = 0; i < r; i++) {
			String str = scan.next();
			for(int j = 0; j < c; j++)
				arr[i][j] = str.charAt(j);
		}
		//ÀÔ·Â ³¡
		boolean t = false; 
		int count = scan.nextInt();
		while(count--> 0) {
			int height = scan.nextInt() - 1;
			boolean is = false;
			int index = 0;
			if(t) {
				for(int i = c - 1; i >= 0; i--){
					if(arr[r - 1 - height][i] == 'x') {
						arr[r - 1 - height][i] = '.';
						index = i;
						is = true;
						break;
					}
				}
			}
			else {
				for(int i = 0; i < c; i++) {
					if(arr[r - 1 - height][i] == 'x') {
						arr[r - 1 - height][i] = '.';
						index = i;
						is = true;
						break;
					}
				}
			}
			t = !t;
			if(!is) continue;
			if(r - 2 - height >= 0) {
				int x = r - 1 - height;
				int y = index;
				for(int i = 0; i < 4; i++) {
					ArrayList<Point> list = new ArrayList<>();
					Queue<Point> queue = new LinkedList<>();
					boolean[][] visit = new boolean[r][c];
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];
					if(nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if(arr[nx][ny] == 'x') {
						list.add(new Point(nx, ny));
						visit[nx][ny] = true;
						queue.offer(new Point(nx, ny));
						while(!queue.isEmpty()) {
							Point now = queue.poll();
							for(int j = 0; j < 4; j++) {
								nx = now.x + dir[j][0];
								ny = now.y + dir[j][1];
								if(nx < 0 || ny < 0 || nx >= r || ny >= c)
									continue;
								if(visit[nx][ny])
									continue;
								if(arr[nx][ny] == '.')
									continue;
								visit[nx][ny] = true;
								queue.offer(new Point(nx, ny));
								list.add(new Point(nx, ny));
							}
						}
						int h = 0;
						for(int j = 1 ; j <= r - 1; j++) {
							boolean isOk = true;
							for(Point now : list) {
								if(now.x + j >= r || (!visit[now.x + j][now.y]&& arr[now.x + j][now.y] == 'x')) {
									h = j;
									isOk = false;
									break;
								}
							}
							if(!isOk)
								break;
						}
						for(Point now : list) 
							arr[now.x][now.y] = '.';
						for(Point next : list) 
							arr[next.x + h - 1][next.y] = 'x';
					}
				}				
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
