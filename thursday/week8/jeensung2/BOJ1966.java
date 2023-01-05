package jeensung2;

import java.util.*;
class BOJ1966{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[] arr = new int[n];
			int result = 0;
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> (o2 - o1));
			for(int i = 0; i < n; i++) {
				int x = scan.nextInt();
				arr[i] = x;
				queue.offer(x);
				if(i == m)
					result = x;
			}
			boolean[] visit = new boolean[n];
			int index = 0;
			int count = 1;
			while(true) {
				if(visit[index] || arr[index] != queue.peek()) {
					index++;
					if(index == n)
						index = 0;
					continue;
				}
				else if(arr[index] == queue.peek()){
					if(arr[index] == result) {
						if(index == m) {
							System.out.println(count);
							break;
						}
					}else {
						queue.poll();
					}
					visit[index] = true;
					count++;
					index++;
				}
				if(index == n)
					index = 0;
			}
		}
	}
}