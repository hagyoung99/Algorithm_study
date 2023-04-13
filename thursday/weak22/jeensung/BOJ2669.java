package jeensung;
import java.util.*;
public class BOJ2669 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[][] arr = new int[101][101];
		for(int i = 0; i < 4; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			for(int a = x1; a < x2; a++)
				for(int b = y1; b < y2; b++)
					arr[a][b] = 1;
		}
		int count = 0;
		for(int i = 0; i < 101; i++)
			for(int j = 0; j < 101; j++)
				if(arr[i][j] == 1)
					count++;
		System.out.println(count);
	}

}
