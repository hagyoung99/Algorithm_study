package thursday.week10.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        
        int max = Integer.MAX_VALUE;
        for(int i=0;i<K;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.min(max, arr[i]);
        }

        int min = 0;
        int answer = 0;
        while(min<=max){
            int mid = (min+max)/2;
            int cnt = 0;
            for(int x:arr){
                int num = x;
                while(num/mid>0){
                    cnt++;
                    num /= mid;
                }
            }
            if(cnt>=N){
                min = mid+1;
                answer = Math.max(answer, mid);
            } else {
                max = mid-1;
            }
        }
        System.out.println(answer);
    }
}
