package week30;
import java.util.*;
class Ground{
	int x;
	int cost;
	Ground(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}
public class BOJ14938 {
	static int n, m, r;
	static int[] map;
	static int[] arr;
	static List<Ground>[] list;
	static int answer = 0;
	static PriorityQueue<Ground> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		r = scan.nextInt();
		map = new int[n + 1];
		list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		for(int i = 1; i <= n; i++)
			map[i] = scan.nextInt();
		for(int i = 0; i < r; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int t = scan.nextInt();
			list[a].add(new Ground(b, t));
			list[b].add(new Ground(a, t));
		}
		for(int i = 1; i <= n; i++) {
			queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
			arr = new int[n + 1];
			for(int j = 1; j <= n; j++)
				arr[j] = 10000000;
			arr[i] = 0;
			queue.offer(new Ground(i, 0));
			dijkstra();
		}
		System.out.println(answer);
	}
 	static void dijkstra() {
 		while(!queue.isEmpty()) {
 			Ground now = queue.poll();
 			for(Ground next : list[now.x]) {
 				if(arr[next.x] > now.cost + next.cost) {
 					arr[next.x] = now.cost + next.cost;
 					queue.offer(new Ground(next.x, arr[next.x]));
 				}
 			}
 		}
 		int temp = 0;
 		for(int i = 1; i <= n; i++) {
 			if(arr[i] <= m)
 				temp += map[i];
 		}
 		answer = Math.max(temp, answer);
 	}
}
