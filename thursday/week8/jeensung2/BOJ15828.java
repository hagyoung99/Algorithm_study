package jeensung2;
import java.util.*;
public class BOJ15828 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		while(true) {
			int x = scan.nextInt();
			if(x == -1)
				break;
			if(x > 0) {
				if(queue.size() < n)
					queue.offer(x);
			}
			else if(x == 0)
				if(!queue.isEmpty())
					queue.poll();
		}
		while(!queue.isEmpty())
			System.out.print(queue.poll() + " ");
	}

}
