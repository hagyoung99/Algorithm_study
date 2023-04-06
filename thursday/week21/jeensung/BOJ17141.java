import java.awt.Point;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] arr;
	static boolean[] visit;
	static int time = Integer.MAX_VALUE;
	static int count = 0;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static List<Point> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				arr[i][j] = scan.nextInt();
				if(arr[i][j] != 1)
					count++;
				if(arr[i][j] == 2) {
					list.add(new Point(i, j));
					arr[i][j] = 0;
				}
			}
		visit = new boolean[list.size()];
		List<Point> temp = new ArrayList<>();
		dfs(0, 0, temp);
		System.out.println(time);
	}
	static void dfs(int index, int idx, List<Point> temp) {
		if(index == m) {
			int a = 0;
			int x = 0;
			x += temp.size();
			int[][] map = new int[n][n];
			for(int i = 0; i < n; i++)
				map[i] = arr[i].clone();
			Queue<Point> gg = new LinkedList<>();
			gg.addAll(temp);
			while(x < count) {
				while(!gg.isEmpty()) {
					Point now = gg.poll();
					for(int i = 0; i < 4; i++) {
						int nx = now.x + dir[i][0];
						int ny = now.y + dir[i][1];
						if(nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if(map[nx][ny] == 2 || map[nx][ny] == 1)
							continue;
						map[nx][ny] = 2;
						x++;
						gg.add(new Point(nx, ny));
					}
				}
				a++;
			}
			time = Math.min(a, time);
			return;
		}
		for(int i = idx; i < list.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[list.get(i).x][list.get(i).y] = 2;
				temp.add(list.get(i));
				dfs(index + 1, i, temp);
				temp.remove(temp.indexOf(list.get(i)));
				arr[list.get(i).x][list.get(i).y] = 0;
				visit[i] = false;
			}
		}
	}
}
