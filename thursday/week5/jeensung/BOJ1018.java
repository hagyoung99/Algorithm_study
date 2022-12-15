package jeensung;
import java.util.*;
public class BOJ1018 {
	static int n, m;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < m; j++) 
				if(str.charAt(j) == 'W')
					arr[i][j] = 0;
				else arr[i][j] = 1;
				//W´Â 0, B´Â 1
		}
		scan.close();
		int[] temp1 = {0, 1, 0, 1, 0, 1, 0, 1};
		int[] temp2 = {1, 0, 1, 0, 1, 0, 1, 0};
		int count = Integer.MAX_VALUE;
		for(int i = 0; i < n - 7; i++) {
			for(int j = 0; j < m - 7; j++) {
				int[][] ans = new int[8][8];
				for(int k = 0; k < 2; k++) {
					int s = 0;
					if(k == 0) {
						for(int a = 0; a < 8; a++)
							if(a % 2 == 0)
								ans[a] = temp1;
							else ans[a] = temp2;
						for(int a = 0; a < 8; a++) 
							for(int b = 0; b < 8; b++) 
								if(ans[a][b] != arr[a + i][b + j]) 
									s++;

					}
					else {
						for(int a = 0; a < 8; a++)
							if(a % 2 == 0)
								ans[a] = temp2;
							else ans[a] = temp1;
						for(int a = 0; a < 8; a++) 
							for(int b = 0; b < 8; b++) 
								if(ans[a][b] != arr[a + i][b + j]) 
									s++;
					}
					count = Math.min(count, s);
				}
			}
		}
		System.out.println(count);
	}
}
