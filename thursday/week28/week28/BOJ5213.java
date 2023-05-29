package week28;
import java.util.*;
class Tutor{
	int x;
	int y;
	Tutor (int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ5213 {
	static int n;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int[][] arr;
	static int[][] ans;
	static int[] map;
	static boolean[][] visit;
	static int answer = Integer.MAX_VALUE;
	static Queue<Tutor> queue = new LinkedList<>();
	static int t = 1;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n][n * 2];
		ans = new int[n][n * 2];
		visit = new boolean[n][n * 2];
		boolean odd = false;
		int count = 1;
		int index = 0;
		for(int i = 0; i < n; i++) { 
			if(!odd) {
				for(int j = 0; j < n * 2; j++) { 
					arr[i][j] = scan.nextInt();
					ans[i][j] = count;
					index++;
					if(index == 2) {
						index = 0;
						count++;
					}
				}
				odd = true;
			}
			else { 
				for(int j = 1; j < n * 2 - 1; j++) {
					arr[i][j] = scan.nextInt();
					ans[i][j] = count;
					index++;
					if(index == 2) {
						index = 0;
						count++;
					}
				}
				odd = false;
			}
		}
		map = new int[count + 1];
		queue.offer(new Tutor(0, 0));
		queue.offer(new Tutor(0, 1));
		visit[0][1] = true;
		visit[0][0] = true;
		bfs();
		Stack<Integer> stack = new Stack<>();
		int a = t;
		while(a != 0){
			stack.add(a);
			a = map[a];
		} 
		System.out.println(stack.size());
		System.out.print(stack.pop());
		while(!stack.isEmpty())
			System.out.print(" " + stack.pop());
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Tutor now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1]; 
				t = Math.max(t, ans[now.x][now.y]);
				if(nx < 0 || ny < 0 || nx >= n || ny >= 2 * n || arr[nx][ny] == 0)
					continue;
				if(visit[nx][ny])
					continue;
				if(arr[nx][ny] != arr[now.x][now.y]) continue;
				visit[nx][ny] = true;
				queue.offer(new Tutor(nx, ny));
				if(i == 2) {
					visit[nx][ny + 1] = true;
					queue.offer(new Tutor(nx, ny + 1));
				}else if(i == 3) {
					visit[nx][ny - 1] = true;
					queue.offer(new Tutor(nx, ny - 1));
				}else if(now.x % 2 == 1 && now.y % 2 == 1 && (i == 0 || i == 1)) {
					visit[nx][ny - 1] = true;
					queue.offer(new Tutor(nx, ny));
					queue.offer(new Tutor(nx, ny - 1));
				}
				else if(now.x % 2 == 1 && now.y % 2 == 0 &&(i == 0 || i == 1)) {
					visit[nx][ny + 1] = true;
					queue.offer(new Tutor(nx, ny + 1));
				}
				else if(now.x % 2 == 0 && now.y % 2 == 1 &&(i == 0 || i == 1)) {
					visit[nx][ny + 1] = true;
					queue.offer(new Tutor(nx, ny + 1));
				}
				else if(now.x % 2 == 0 && now.y % 2 == 0 &&(i == 0 || i == 1)) {
					visit[nx][ny - 1] = true;
					queue.offer(new Tutor(nx, ny - 1));
				}
				map[ans[nx][ny]] = ans[now.x][now.y];
			}
		}
	}
	//1 2 2 3 6 6
	//0 2 4 3 5 0
	//6 6 4 5 5 6
}
