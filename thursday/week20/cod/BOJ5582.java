package cod;
import java.util.*;
public class BOJ5582 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String str2 = scan.next();
		char[] arr = str.toCharArray();
		char[] ans = str2.toCharArray();
		int[][] map = new int[str.length() + 1][str2.length() + 1];
		int answer = 0;
		for(int i = 1; i <= str.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(arr[i - 1] == ans[j - 1])
					map[i][j] = map[i - 1][j - 1] + 1;
				answer = Math.max(answer, map[i][j]);
			}
		}
		System.out.println(answer);
	}
}
