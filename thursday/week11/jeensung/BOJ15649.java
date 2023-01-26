import java.util.*;
public class BOJ15649{
    public static int[] arr;
	public static boolean[] visit;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int m = scan.nextInt();
        int n = scan.nextInt();
        visit = new boolean[m];
        arr = new int[n];
        dfs(m,n,0);
    }
    public static void dfs(int m, int n, int depth){
        if(depth == n){
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < m; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(m,n,depth + 1);
                visit[i] = false;
            }
        }
    }
}