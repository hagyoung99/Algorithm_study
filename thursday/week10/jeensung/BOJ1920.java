package samsung01.jeensung;
import java.util.*;
public class BOJ1920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		HashSet<Long> set = new HashSet<Long>();
		for(int i = 0; i < n; i++)
			set.add(scan.nextLong());
		int m = scan.nextInt();
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			if(set.contains((long)x))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
