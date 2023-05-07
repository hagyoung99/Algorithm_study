package week25;
import java.util.*;
class Points{
	int x;
	int y;
	Points(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ5567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		List<Integer>[] list = new List[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		boolean[] visit = new boolean[n + 1];
		visit[1] = true;
		int answer = 0;
		Queue<Points> queue = new LinkedList<>();
		queue.offer(new Points(1, 0));
		while(!queue.isEmpty()) {
			Points now = queue.poll();
			for(int next : list[now.x]) {
				if(!visit[next] && now.y < 2) {
					queue.offer(new Points(next, now.y + 1));
					visit[next] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}
