package thursday.week9.hagyoung99;

import java.io.*;
import java.util.*;
public class Q5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> d = new ArrayDeque<>();
            String numbers = br.readLine();
            numbers = numbers.substring(1, numbers.length()-1);
            String[] number = numbers.split(",");

            for(String x:number) if(!x.isEmpty()) d.add(Integer.parseInt(x));
            

            boolean stop = false;
            boolean front = true;
            for(char x:p.toCharArray()){
                if(x=='R'){
                    front = !front;
                } else {
                    if(d.isEmpty()) {
                        sb.append("error");
                        stop = true;
                        break;
                    } else {
                        if(front) d.pollFirst();
                        else d.pollLast();
                    }
                }
            }
            if(!stop){
                sb.append("[");
                if(front){
                    while(d.size()>1) sb.append(d.pollFirst()).append(","); 
                    if(d.peekFirst() != null)sb.append(d.pollFirst());
                    sb.append("]");
                } else {
                    while(d.size()>1) sb.append(d.pollLast()).append(","); 
                    if(d.peekLast() != null)sb.append(d.pollLast());
                    sb.append("]");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
