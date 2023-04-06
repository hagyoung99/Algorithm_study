package jeensung;
import java.util.*;
public class BOJ2635 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int max = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			Queue<Integer> g = new LinkedList<>();
			int temp = 1;
			g.offer(n);
			int t = n;
			int x = i;
			while(t - x > -1) {
				temp++;
				int a = t;
				t = x;
				g.offer(x);
				x = a - x;
			}
			g.offer(x);
			if(max < temp) {
				max = temp;
				queue = new LinkedList<>();
				queue.addAll(g);
			}
		}
		System.out.println(max + 1);
		while(!queue.isEmpty())
			System.out.print(queue.poll() + " ");
	}

}
