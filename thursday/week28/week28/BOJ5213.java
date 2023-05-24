package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Tutor{
	int x;
	int y;
	Tutor (int x, int y){
		this.x =  x;
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n * 2];
		ans = new int[n][n * 2];
		visit = new boolean[n][n * 2];
		boolean odd = false;
		int count = 1;
		for(int i = 0; i < n; i++) { 
			if(!odd) {
				for(int j = 0; j < n; j++) { 
					String[] input = br.readLine().split(" ");
					arr[i][j * 2] = Integer.parseInt(input[0]);
					arr[i][j * 2 + 1]= Integer.parseInt(input[1]);
					ans[i][j * 2] = count;
					ans[i][j * 2 + 1] = count++;
				}
				odd = true;
			}
			else { 
				for(int j = 0; j < n - 1; j++) {
					String[] input = br.readLine().split(" ");
					arr[i][j * 2 + 1] = Integer.parseInt(input[0]);
					arr[i][j * 2 + 2] = Integer.parseInt(input[1]);
					ans[i][j * 2 + 1] = count;
					ans[i][j * 2 + 2] = count++;
				}
				odd = false;
			}
		}
		map = new int[count + 1];
		queue.offer(new Tutor(0, 0));
		visit[0][0] = true;
		bfs();
		Stack<Integer> stack = new Stack<>();
		int a = t;
		while(a != 0){
			stack.add(a);
			a = map[a];
		}
		System.out.println(stack.size());
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Tutor now = queue.poll();
			t = Math.max(t, ans[now.x][now.y]);
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dir[i][0];
				int ny = now.y + dir[i][1]; 
				if(nx < 0 || ny < 0 || nx >= n || ny >= 2 * n || arr[nx][ny] == 0)
					continue;
				if(visit[nx][ny])
					continue;
				if(now.x != nx && arr[now.x][now.y] == arr[nx][ny]) {
					visit[nx][ny] = true;
					queue.offer(new Tutor(nx, ny));
					map[ans[nx][ny]] = ans[now.x][now.y];
				}else if(now.x == nx && ans[now.x][now.y] == ans[nx][ny]) {
					visit[nx][ny] = true;
					queue.offer(new Tutor(nx, ny));
				}else if(now.x == nx && ans[now.x][now.y] != ans[nx][ny] && arr[now.x][now.y] == arr[nx][ny]) {
					visit[nx][ny] = true;
					queue.offer(new Tutor(nx, ny));
					map[ans[nx][ny]] = ans[now.x][now.y]; 
				}

			}
		}
	}
	//1 2 2 3 6 6
	//0 2 4 3 5 0
	//6 6 4 5 5 6
}
