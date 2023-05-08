package week26;
import java.awt.Point;
import java.util.*;
public class BOJ1941 {
	static int answer = 0;
	static char[][] arr = new char[5][5];
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[] visit = new boolean[25];
	static boolean[][] visit2 = new boolean[5][5];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			String str = scan.next();
			for(int j = 0; j < 5; j++)
				arr[i][j] = str.charAt(j);
		}	
		dfs(0, 7, 0, 0);
		System.out.println(answer);
	}
	static void dfs(int count, int end, int m, int S) {
		if(count == end) {
			if(S < 4)
				return;
			answer++;
			return;
		}
		for(int i = m; i < 25; i++) {
			for(int k = 0; k < 4; k++) {
				int nx = i / 5 + dir[k][0];
				int ny = i % 5 + dir[k][1];
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
					continue;
				if(!visit[nx * 5 + ny]) {
					visit[nx * 5 + ny] = true;
					if(arr[nx][ny] == 'S')
						dfs(count + 1, end, nx * 5 + ny, S + 1);
					else
						dfs(count + 1, end, nx * 5 + ny, S);
					visit[nx * 5 + ny] = false;
				}
			}
		}
	}
}
