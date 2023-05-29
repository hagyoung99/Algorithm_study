package week28;
import java.util.*;
public class BOJ1189 {
	static int r, c, k;
	static char[][]arr;
	static boolean[][] visit;
	static int answer = 0;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		r = scan.nextInt();
		c = scan.nextInt();
		k = scan.nextInt();
		arr = new char[r][c];
		visit = new boolean[r][c];
		visit[r - 1][0] = true;
		for(int i = 0; i < r; i++) {
			String str =  scan.next();
			for(int j = 0; j < c; j++) 
				arr[i][j] = str.charAt(j);
		}
		dfs(r - 1, 0, 1);
		System.out.println(answer);
	}
	static void dfs(int x, int y, int count) {
		if(count > k) return;
		if(count == k) {
			if(x == 0 && y == c - 1)
				answer++;
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			if(visit[nx][ny])
				continue;
			if(arr[nx][ny] == 'T')
				continue;
			visit[nx][ny] = true;
			dfs(nx, ny, count + 1);
			visit[nx][ny] = false;
		}
	}
}
