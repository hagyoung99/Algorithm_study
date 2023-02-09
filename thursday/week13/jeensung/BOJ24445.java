package jeensung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ24445 {
	static int n, m, r;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static int[] ans;
	static int count = 1;
	static List<Integer>[] arr;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new List[n + 1];
		ans = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		for(int i = 1; i <= n; i++)
			if(arr[i].size() > 0)
				Collections.sort(arr[i], (o1, o2) -> (o2 - o1));
		visit = new boolean[n + 1];
		queue.offer(r);
		visit[r] = true;
		ans[r] = 1;
		bfs(r);
		for(int i = 1; i <= n; i++)
			System.out.println(ans[i]);
	}
	static void bfs(int start) {
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : arr[now]) {
				if(visit[next])
					continue;
				ans[next] = ++count;
				visit[next] = true;
				queue.offer(next);
			}
		}
	}
}