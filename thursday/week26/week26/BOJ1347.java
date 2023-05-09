package week26;
import java.util.*;

public class BOJ1347 {
	static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char[] arr = new char[n];
		String str = scan.next();
		for(int i = 0; i < n; i++)
			arr[i] = str.charAt(i);
		boolean[][] visit = new boolean[101][101];
		int minX = 50;
		int minY = 50;
		int maxX = 50;
		int maxY = 50;
		int x = 50;
		int y = 50;
		int d = 0;
		visit[x][y] = true;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 'R')
				d = (d + 1) % 4;
			else if(arr[i] == 'L')
				d = ((d - 1) + 4) % 4;
			else {
				x += dir[d][0];
				y += dir[d][1];
				visit[x][y] = true;
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
			}
		}
		String s = "";
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				if(visit[i][j])
					s += ".";
				else
					s += "#";
			}
			s += "\n";
		}
		System.out.println(s);
	}

}
