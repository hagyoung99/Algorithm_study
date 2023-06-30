package week33;
import java.util.*;
public class BOJ1072 {
	static int x, y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y = scan.nextInt();
		int z = (int)((long)y * 100 / x);
		
		int answer = -1;
		int left = 0;
		int right = 1000000000;
		while(left <= right) {
			int mid = (left + right) / 2;
			if ((int)((long) (y + mid) * 100 / (x + mid)) != z) {
				answer = mid;
				right = mid - 1;
			}else
				left = mid + 1;
		}
		System.out.println(answer);
	}
}
