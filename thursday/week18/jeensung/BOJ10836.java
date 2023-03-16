package jeensung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ10836 {
	static int m, n;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][m];
		for(int i = 0; i < m; i++)
			Arrays.fill(arr[i], 1);
		while(n--> 0) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			for(int i = m - 1; i > 0; i--) {
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					arr[i][0] += 1;
				} else if(two != 0) {
					two--;
					arr[i][0] += 2;
				}
			}
			for(int i = 0; i < m; i++) {
				if(zero != 0) {
					zero--;
				} else if(one != 0) {
					one--;
					arr[0][i] += 1;
				} else if(two != 0) {
					two--;
					arr[0][i] += 2;
				}
			}
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				arr[i][j] = Math.max(arr[i - 1][j], Math.max(arr[i][j - 1], arr[i - 1][j - 1]));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			for(int j =  0; j < m; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
