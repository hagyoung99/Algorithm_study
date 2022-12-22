package thursday.week6.hagyoung99;

import java.io.*;
import java.util.*;
public class Q10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }
        System.out.println(sb);
    }
}
