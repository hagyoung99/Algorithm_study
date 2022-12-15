package jeensung;
import java.util.*;
public class BOJ14425 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		HashSet<String> hashSet1 = new HashSet<String>();
		for(int i = 0; i < n; i++)
			hashSet1.add(scan.next());
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < m; i++)
			list.add(scan.next());
		int count = 0;
		for(int i = 0; i < list.size(); i++)
			if(hashSet1.contains(list.get(i)))
				count++;
		System.out.println(count);
	}
}
