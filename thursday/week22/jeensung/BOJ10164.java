package jeensung;
import java.util.*;
public class BOJ10164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int[][] arr = new int[n][m];
		int count = 1;
		int nx = 0;
		int ny = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				arr[i][j] = 1;
				if(count == k) {
					nx = i;
					ny = j;
				}
				count++;
			}
		for(int i = 1; i <= nx; i++)
			for(int j = 1; j <= ny; j++) 
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
		for(int i = nx; i < n; i++)
			for(int j = ny; j < m; j++) {
				if(i == nx || j == ny)
					arr[i][j] = arr[nx][ny];
				else
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		System.out.println(arr[n - 1][m - 1]);
		
	}
}
