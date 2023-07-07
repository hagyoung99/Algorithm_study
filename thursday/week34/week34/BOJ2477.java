package week34;
import java.util.*;
public class BOJ2477 {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 6; i++) {
			scan.next();
			list.add(scan.nextInt());
		}
		int t = 0;
		for(int i = 0; i <  5; i++) {
			int temp = list.get(i) * list.get(i + 1);
			if(temp > answer)
				answer = temp;
			t += temp;
		}
		t += list.get(0) * list.get(5);
		if(list.get(0) * list.get(5) > answer)
			answer = list.get(0) * list.get(5);
		System.out.println(k * (t - 2 * answer));
	}

}
