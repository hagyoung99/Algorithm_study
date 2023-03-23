package jeensung;
import java.util.*;
public class BOJ5212 {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		char[][]arr = new char[r][c];
		for(int i = 0; i <r ; i++) {
			String str = scan.next();
			for(int j = 0; j < c; j++)
				arr[i][j] = str.charAt(j);
		}
		  int minR = 10, minC = 10;
	        int maxR = 0, maxC = 0;
		char[][] map = new char[r][c];
		for(int i = 0; i < r; i++)
			map[i] = arr[i].clone();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				int count = 0;
				if(arr[i][j] == '.') continue;
				for(int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if(nx < 0 || ny < 0 || nx >= r || ny >= c ||
							map[nx][ny] == '.') 
						count++;
				}
				if(count >= 3)
					arr[i][j] = '.';
				else {
					 minR = Math.min(minR, i); // 지도 출력 범위 갱신
                     minC = Math.min(minC, j);
                     maxR = Math.max(maxR, i);
                     maxC = Math.max(maxC, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
	}

}
