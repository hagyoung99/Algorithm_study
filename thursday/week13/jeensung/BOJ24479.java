package jeensung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ24479 {
	static int n, m, r;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static int[] ans;
	static int count = 0;
	static List<Integer>[] arr;
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
		for(int i = 1; i <= n; i++) {
			if(arr[i].size() > 0)
				Collections.sort(arr[i]);
		}
		visit = new boolean[n + 1];
		visit[r] = true;
		dfs(r);
		for(int i = 1; i <= n; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}
	static void dfs(int start) {
		ans[start] = ++count;
		for(int i : arr[start]) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
}
