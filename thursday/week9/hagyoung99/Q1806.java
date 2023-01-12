package thursday.week9.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        int lt = 0, rt = 0, sum = 0;
        while(lt<N){
            if(sum>=S || rt == N){
                if(sum>= S) answer = Math.min(answer, (rt-lt));
                sum -= arr[lt++];
            }else if(sum<S) sum+= arr[rt++];
        }
        answer = answer<Integer.MAX_VALUE ? answer : 0;
        System.out.println(answer);
    }
}
