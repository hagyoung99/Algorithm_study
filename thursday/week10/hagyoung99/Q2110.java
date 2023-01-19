package thursday.week10.hagyoung99;

import java.io.*;
import java.util.*;
public class Q2110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = 0;
        int lt = 1;
        int rt = arr[N-1];
        while(lt<=rt){
            int mid = (lt+rt)/2;

            int cnt = 1;    //공유기 수
            int ep = arr[0];    //공유기 설치 시작점
            for(int i=1;i<N;i++){
                if(arr[i]-ep >= mid){
                    cnt++;
                    ep = arr[i];
                }
            }

            if(cnt>=C){
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }
        System.out.println(answer);
    }
}
