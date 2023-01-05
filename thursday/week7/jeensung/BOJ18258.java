package jeensung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ18258 {
    static int n, m, k;
    static long[] arr;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        while(n--> 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.getFirst()).append('\n');
                    }else {
                        sb.append(-1).append('\n');
                    }
                    break;
                case "back":
                    Integer num = queue.peekLast();
                    if(num == null){
                        sb.append(-1).append('\n');
                    }else
                        sb.append(num).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        sb.append(1).append('\n');
                    }else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "pop":
                    if(!queue.isEmpty()) {
                        sb.append(queue.pollFirst()).append('\n');
                    }else{
                        sb.append(-1).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}