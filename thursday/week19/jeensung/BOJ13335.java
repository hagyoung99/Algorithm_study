package jeensung;
import java.util.*;
public class BOJ13335 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int w = scan.nextInt();
		int l = scan.nextInt();
		Queue<Integer> truck = new LinkedList<>();
		for(int i = 0; i < n; i++)
			truck.offer(scan.nextInt());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < w; i++)
			queue.add(0);
		int weight = 0;
		int time = 0;
		while(!queue.isEmpty()) {
			time++;
			weight -= queue.poll();
			if(!truck.isEmpty()) {
				if(truck.peek() + weight <= l) {
					weight += truck.peek();
					queue.offer(truck.poll());
				}else
					queue.offer(0);
			}
		}
		System.out.println(time);
	}

}
