package thursday.week7.hagyoung99;

import java.io.*;
import java.util.*;
public class Q10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() >= 2) {
                if(st.nextToken().equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            }else{
                String s = st.nextToken();
                if(s.equals("pop")){
                    if(!stack.empty()) sb.append(stack.pop()).append("\n");
                    else sb.append("-1").append("\n");
                } else if(s.equals("size")) {
                    sb.append(Integer.toString(stack.size())).append("\n");
                }else if(s.equals("empty")){
                    if(stack.empty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                } else {
                    if(!stack.empty()) sb.append(stack.peek()).append("\n");
                    else sb.append("-1").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
