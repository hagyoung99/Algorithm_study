import java.util.*;

public class BOJ15652 {
 
	public static int[] arr;
	public static int N, M;
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
        
		arr = new int[M];
        
		dfs(1,0);
        System.out.print(sb);
	}
 
	public static void dfs(int t, int depth) {
		if (depth == M) {
			for (int val : arr) {
                
				sb.append(val + " ");
			}	
			sb.append('\n');
			return;
		}
        
		for (int i = t; i <= N; i++) {
			t = i;

			arr[depth] = t;
			dfs(t, depth + 1);
			
		}
	}
}