package thursday.week7.hagyoung99;

import java.io.*;
import java.util.*;
public class Q9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = in.readLine();

        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            Stack<Character> st = new Stack<>();
            boolean flag = true;
            for(char x:arr[i].toCharArray()){
                if(x == '(') st.push(x);
                else{
                    if(st.empty()) flag = false;
                    else st.pop();
                }
            }
            if(!flag) answer.add("NO");
            else if(st.empty()) answer.add("YES");
            else answer.add("NO");
        }
        
        for(String x: answer) System.out.println(x);
    }
}
