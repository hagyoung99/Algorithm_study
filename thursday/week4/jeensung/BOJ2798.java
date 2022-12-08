package jeensung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798{
    static int[] arr;
    static int n;
    static int m;
    static boolean visit[];
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new int[n];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);   
        System.out.println(max);
        
    }
    public static void dfs(int t, int sum){
        if(t == 3){
        	if(sum <= m){
                max = Math.max(max, sum);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(t + 1, sum + arr[i]);
                visit[i] = false;
            }
        }
    }
}