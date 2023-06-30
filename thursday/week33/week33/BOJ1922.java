package week33;
import java.util.*;
class Network{
	int x;
	int y;
	int cost;
	Network(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class BOJ1922 {
	static int n,m;
	static PriorityQueue<Network> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
	static int[] parents;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		parents = new int[n + 1];
		for(int i = 1; i <= n; i++)
			parents[i] = i;
		int answer = 0;
		while(m -- > 0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			queue.offer(new Network(a, b, c));
		}
		while(!queue.isEmpty()) {
			Network now = queue.poll();
			int x = find(now.x);
			int y = find(now.y);
			if(x == y) continue;
			union(x, y);
			answer += now.cost;
		}
		System.out.println(answer);
	}
	static int find(int x) {
		if(x == parents[x]) return x;
		parents[x] = find(parents[x]);
		return parents[x];
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px != py)
			parents[px] = py;
		else
			return;
	}
}
