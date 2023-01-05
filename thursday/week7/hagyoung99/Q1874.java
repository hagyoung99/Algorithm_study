package thursday.week7.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int number = 0;
        while(N-- > 0){
            int n = Integer.parseInt(br.readLine());
            if(number < n) {
                for(int i=number+1;i<=n;i++){
                    s.push(i);
                    sb.append("+").append("\n");
                }
                number = n;
            } else if(s.peek() != n){
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
