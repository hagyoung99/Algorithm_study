package week34;
import java.util.*;
class Electro{
	int x;
	int y;
	int cost;
	Electro(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
public class BOJ6497 {
	static int m, n;
	static int answer = 0;
	static int[] parents;
	static PriorityQueue<Electro> queue = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			answer = 0;
			m = scan.nextInt();
			n = scan.nextInt();
			if(m == 0 && n == 0)
				System.exit(0);
			parents = new int[m];
			for(int i = 0; i < m; i++)
				parents[i] = i;
			for(int i = 1; i <= n; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int z = scan.nextInt();
				queue.offer(new Electro(x, y, z));
				answer += z;
			}
			int min = 0;
			while(!queue.isEmpty()) {
				Electro now = queue.poll();
				int x = find(now.x);
				int y = find(now.y);
				if(x == y) continue;
				union(x, y);
				min += now.cost;
			}
			System.out.println(answer - min);
		}
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
