package thursday.week11.hagyoung;

import java.io.*;
import java.util.*;
public class Q1927 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-->0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
            } else pq.add(x);
        }

        System.out.println(sb);
    }
}
