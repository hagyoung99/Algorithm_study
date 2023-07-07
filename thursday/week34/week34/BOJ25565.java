package week34;
import java.util.*;
public class BOJ25565 {
	static int n, m, k;
	static boolean[][] arr;
	static int[][] map;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		arr = new boolean[n][m];
		map = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(scan.nextInt() == 1)
					arr[i][j] = true;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]) {
					boolean X = true;
					boolean Y = true;
					if(n >= k + i) {
						for(int t = 0; t < k; t++) {
							if(arr[i + t][j] == false) {
								Y = false;
								break;
							}
						}
						if(Y) {
							for(int t = 0; t < k; t++)
								map[i + t][j]++;
							answer++;
						}
					}
					if(m >= k + j) {
						for(int t = 0; t < k; t++) {
							if(arr[i][j + t] == false)
								X = false;
						}
						if(X) {
							for(int t = 0; t < k; t++)
								map[i][j + t]++;
							answer++;
						}
					}
				}
			}
		}
		int tt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == answer) {
					tt++;
					sb.append((i + 1) + " " + (j + 1) + "\n");
				}
			}
		}
		System.out.println(tt);
		System.out.println(sb);
	}
}
