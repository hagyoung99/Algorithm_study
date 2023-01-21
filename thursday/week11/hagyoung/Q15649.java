package thursday.week11.hagyoung;

import java.io.*;
import java.util.*;
public class Q15649 {
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        DFS(N, M, 0);
        System.out.println(sb);
    }

    public static void DFS(int N, int M, int cnt){
        if(cnt == M){
            for(int x : arr){
                sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[cnt] = i+1;
                DFS(N, M, cnt+1);
                visit[i] = false;
            }
        }
    }
}
