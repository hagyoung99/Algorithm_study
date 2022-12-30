package thursday.week7.hagyoung99;

import java.io.*;
import java.util.*;
public class Q18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        int back = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String next = st.nextToken();

            switch(next){
                case "push":{
                    int number = Integer.parseInt(st.nextToken());
                    q.offer(number);
                    back = number;
                    break;
                }
                case "pop":{
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                }
                case "size":{
                    sb.append(q.size()).append("\n");
                    break;
                }
                case "empty":{
                    if(q.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                }
                case "front":{
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                }
                case "back":{
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(back).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
