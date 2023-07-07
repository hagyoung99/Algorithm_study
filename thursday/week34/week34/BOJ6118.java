package week34;
import java.util.*;
class Sum{
	int x;
	int y;
	Sum(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ6118 {
	static int n, m;
	static boolean[] visit;
	static int[] arr;
	static List<Integer>[] list;
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		visit = new boolean[n + 1];
		list = new List[n + 1];
		arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		while(m-- > 0) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		bfs();
		int a = 0;
		int b = 0;
		for(int i = 1; i <= n; i++)
			if(arr[i] == answer) {
				if(a == 0)
					a = i;
				b++;
			}
		System.out.println(a + " " + answer + " " + b);
	}
	static void bfs() {
		Queue<Sum> queue = new LinkedList<>();
		queue.offer(new Sum(1, 0));
		visit[1] = true;
		while(!queue.isEmpty()) {
			Sum now = queue.poll();
			for(int next : list[now.x]) {
				if(visit[next]) continue;
				queue.offer(new Sum(next, now.y + 1));
				arr[next] = now.y + 1;
				answer = Math.max(answer, arr[next]);
				visit[next] = true;
			}
		}
	}
}
