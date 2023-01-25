package thursday.week11.hagyoung;

import java.io.*;
import java.util.*;
public class Q11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
                else if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
                else return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}
