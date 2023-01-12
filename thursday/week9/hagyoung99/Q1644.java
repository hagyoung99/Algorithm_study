package thursday.week9.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //소수 구하기
        boolean prime[] = new boolean[N+1];     
        List<Integer> list = new ArrayList<>();
        prime[0] = prime[1] = true;
        for(int i=2;i*i<=N;i++) for(int j=i*i;j<=N;j+=i) prime[j] = true;
        for(int i=1;i<=N;i++) if(!prime[i]) list.add(i);

        int answer = 0;
        int start = 0, end = 0, sum = 0;
        while(true){
            if(sum >= N) sum-= list.get(start++);
            else if(end == list.size()) break;
            else sum+=list.get(end++);

            if(N==sum) answer++;
        }
        System.out.println(answer);
    }
}
