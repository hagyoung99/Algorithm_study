package thursday.week10.hagyoung99;

import java.io.*;
import java.util.*;
public class Q2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        if(M==0) System.out.println(0);
        else {
            int min = 0;
            while(min<max){
                int mid = (min+max)/2;
                long sum = 0;
                for(int x: arr) if(x>mid) sum += x-mid;
                if(sum<M) max = mid;
                else min = mid+1;
            }
            System.out.println(min-1);
        }
    }

        
}
