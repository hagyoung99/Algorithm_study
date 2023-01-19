package thursday.week10.hagyoung99;

import java.io.*;
public class Q1300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int lt = 1;
        int rt = K;

        while(lt<rt){
            int mid = (lt+rt)/2;
            int cnt = 0;

            for(int i=1;i<=N;i++) cnt += Math.min(mid/i, N);

            if(K<= cnt) rt = mid;
            else lt = mid +1;
        }
        System.out.println(lt);
    }
}
