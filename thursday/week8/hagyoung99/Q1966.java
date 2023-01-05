package thursday.week8.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while(testcase-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<N;i++) q.offer(new int[] {i, Integer.parseInt(st.nextToken())});

            int cnt = 1;
            while(!q.isEmpty()){
                int[] num = q.poll();
                boolean chk = true;
                for(int[] x:q){
                    if(num[1] < x[1]){
                        chk = false;
                        q.offer(num);
                        break;
                    }
                }
                if(chk){
                    if(num[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    } else {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
