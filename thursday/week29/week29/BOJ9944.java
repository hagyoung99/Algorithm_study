package week29;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ9944 {
	static int n, m;
	static char[][] arr;
	static boolean[][] visit;
	static int answer = Integer.MAX_VALUE;
	static int count;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 1;
		String str = "";
		while((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			answer = Integer.MAX_VALUE; 
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			visit = new boolean[n][m];
			count = 0;
			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < m; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j] == '.')
						count++;
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++)
					if(arr[i][j] == '.') {
						for(int k = 0; k < 4; k++) {
							visit[i][j] = true;
							dfs(i, j, k, 1, 1);
							visit[i][j] = false;
						}
					}
			}
			if (answer == Integer.MAX_VALUE)
				System.out.println("Case " + index + ": " + -1);
			else if(count == 1 && answer == 1)
				System.out.println("Case " + index + ": " + 0);
			else
				System.out.println("Case " + index + ": " + answer);
			index++;
		}
	}
	static void dfs(int x, int y, int d, int sum, int cnt) {
		if(count == sum) {
			answer = Math.min(answer, cnt);
			return;
		}
		int nx = x + dir[d][0]; 
		int ny = y + dir[d][1];
		if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == '.' && !visit[nx][ny]) {
			visit[nx][ny] = true;
			dfs(nx, ny, d, sum + 1, cnt);
			visit[nx][ny] = false;
		}else {
			for(int i = 0; i < 4; i++) {
				if(i == d) continue;
				int px = x + dir[i][0];
				int py = y + dir[i][1];
				if(px >= 0 && py >= 0 && px < n && py < m && arr[px][py] == '.' && !visit[px][py]) {
					visit[px][py] = true;
					dfs(px, py, i, sum + 1, cnt + 1);
					visit[px][py] = false;
				}
			}
		}
	}

}
