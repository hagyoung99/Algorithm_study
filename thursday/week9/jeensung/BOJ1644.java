package samsung01.jeensung;
import java.util.*;
public class BOJ1644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++) {
			int count = 0;
			boolean isOk = true;
			for(int j = 1; j <= Math.sqrt(i); j++) {
				if(i % j == 0)
					count++;
				if(count > 1) {
					isOk = false;
					break;
				}
			}
			if(isOk)
				list.add(i);
		}
		int answer = 0;
		for(int i = 0; i < list.size(); i++) {
			int sum = 0;
			for(int j = i; j < list.size(); j++) {
				sum += list.get(j);
				if(sum > n)
					break;
				if(sum == n) 
					answer++;
			}
		}
		System.out.print(answer);
	}

}
