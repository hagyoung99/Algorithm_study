package week33;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ9742 { 
	static int n;
	static String[] arr;
	static boolean[] visit;
	static int time;
	static String[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		while((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s, " ");
			String str = st.nextToken();
			arr = str.split("");
			visit = new boolean[arr.length];
			ans = new String[arr.length];
			time = 0;
			n = Integer.parseInt(st.nextToken());
			dfs(0);
			System.out.print(str + " " + n + " = ");
			if(time < n)
				System.out.println("No Permutation");
			else {
				for(int i = 0; i < arr.length; i++)
					System.out.print(arr[i]);
				System.out.println();
			}
		}
	}
	static void dfs(int count) {
		if(count == arr.length) {
			time++;
			if(time == n)
				for(int i = 0; i < arr.length; i++)
					arr[i] = ans[i];
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			if(!visit[i]) {
				ans[count] = arr[i];
				visit[i] = true;
				dfs(count + 1);
				visit[i] = false;
			}
		}
	}
}
