package week29;
import java.awt.Point;
import java.util.*;
public class BOJ1325 {
	static int n, m;
	static List<Integer>[] list;
	static boolean[] visit;
	static int answer = 0;
	static List<Integer> tt = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for(int i = 1; i <= m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[y].add(x);
		}
		visit = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			bfs(i);
		}
		for(int i = 0; i < tt.size(); i++)
			System.out.print(tt.get(i) + " ");
	}
	static void bfs(int x) {
		visit[x] = true;
		int temp = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, 1));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int next : list[now.x]) {
				if(visit[next]) continue;
				visit[next] = true;
				queue.offer(new Point(next, now.y + 1));
				temp++;
			}
		}
		if(answer < temp) {
			answer = temp;
			tt = new ArrayList<>();
			tt.add(x);
		}else if(answer == temp)
			tt.add(x);
	}
}
