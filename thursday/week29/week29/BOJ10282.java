package week29;
import java.util.*;
class Hacking{
	int x; //index
	int y; //ºñ¿ë
	Hacking(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ10282 {
	static int n, d, c;
	static int[] arr;
	static List<Hacking>[] list;
	static PriorityQueue<Hacking> queue = new PriorityQueue<>((o1, o2) -> (o1.y - o2.y));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			n = scan.nextInt();
			d = scan.nextInt();
			c = scan.nextInt();
			arr = new int[n + 1];
			list = new List[n + 1];
			queue = new PriorityQueue<>((o1, o2) -> (o1.y - o2.y));
			for(int i = 1; i <= n; i++)
				list[i] = new ArrayList<>();
			for(int i = 1; i <= n; i++)
				arr[i] = 10000000;
			arr[c] = 0;
			for(int i = 0; i < d; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int s = scan.nextInt();
				list[b].add(new Hacking(a, s));
			}
			queue.offer(new Hacking(c, 0));
			dijkstra();

		}
	}
	static void dijkstra() {
		int count = 0;
		int temp = 0;
		while(!queue.isEmpty()) {
			Hacking now = queue.poll();
			for(Hacking next : list[now.x]) {
				if(arr[next.x] > next.y + arr[now.x]) {
					arr[next.x] = next.y + arr[now.x];
					queue.offer(new Hacking(next.x, arr[next.x]));
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 10000000) continue;
			temp++;
			count = Math.max(count, arr[i]);
		}
		System.out.println(temp + " " + count);
	}
}
