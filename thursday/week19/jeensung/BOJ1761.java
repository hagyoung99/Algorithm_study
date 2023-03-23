package jeensung;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
class Point{
	int x;
	int cost;
	Point(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}
public class BOJ1761 {
	static int n, m;
	static List<Point>[] list;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new Point(y, z));
			list[y].add(new Point(x, z));
		}
		for(int i = 1; i <= n; i++)
			Arrays.fill(arr[i], 100000000);
		for(int i = 1; i <= n; i++)
			dfs(i);
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(arr[a][b] + "\n");
		}
		bw.flush();
		bw.close();
	}
	static void dfs(int start) {
		PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		queue.offer(new Point(start, 0));
		boolean[][] visit = new boolean[n + 1][n + 1];
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(Point next : list[now.x]) {				
				if(visit[start][next.x]) continue;
				if(arr[start][next.x] > next.cost + now.cost) {
					visit[start][next.x] = true; 
					arr[start][next.x] = next.cost + now.cost; 
					queue.offer(new Point(next.x, arr[start][next.x]));
				}
			}
		}
	}
}
