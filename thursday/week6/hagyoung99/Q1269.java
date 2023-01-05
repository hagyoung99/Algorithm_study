package thursday.week6.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs1 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) hs1.add(Integer.parseInt(st.nextToken()));

        HashSet<Integer> hs2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) hs2.add(Integer.parseInt(st.nextToken()));

        int answer = 0;
        for(int x : hs1) if(!hs2.contains(x)) answer++;
        for(int x: hs2) if(!hs1.contains(x)) answer++;
        System.out.println(answer);
    }
}
