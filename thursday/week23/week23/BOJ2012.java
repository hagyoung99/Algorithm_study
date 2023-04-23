package week23;
import java.util.*;
public class BOJ2012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
			queue.offer(scan.nextInt());
		int rank = 1;
		long answer = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			answer += Math.abs(now - rank);
			rank++;
		}
		System.out.println(answer);
	}
}
