package week30;
import java.util.*;
public class BOJ16434 {
	static int n, Hatk;
	static int t, a, h;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Hatk = scan.nextInt();
		arr = new int[n][3];
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < 3; j++)
				arr[i][j] = scan.nextInt();
		long min = 1;
		long max = Long.MAX_VALUE;
		while(min <= max) {
			long mid = (min + max) / 2;
			long atk = Hatk;
			long hp = mid;
			boolean alive = true;
			for(int i = 0; i < n; i++) {
				if(arr[i][0] == 1) {
					if(arr[i][2] % atk == 0)
						hp -= ((arr[i][2]/atk) - 1) * arr[i][1];
					else
						hp -= (arr[i][2] / atk) * arr[i][1];
					if(hp <= 0) {
						alive = false;
						break;
					}
				}else {
					hp += arr[i][2];
					if(hp > mid)
						hp = mid;
					atk += arr[i][1];
				}
			}
			if(!alive) min = mid + 1;
			else max = mid - 1;
		}
		System.out.println(min);
	}
}
