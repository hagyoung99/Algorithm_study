package thursday.week12.hagyoung;

import java.io.*;
import java.util.*;
public class Q15652 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M]; 
        DFS(0, N, M, 0, arr);

        System.out.println(sb);
    }

    public static void DFS(int c, int N, int M, int cnt, int[] arr){
        if(M == cnt){
            for(int x:arr) sb.append(x).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=c;i<N;i++){
            arr[cnt] = i+1;
            DFS(i, N, M, cnt+1, arr);
        }
    }
}
