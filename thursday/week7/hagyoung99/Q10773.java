package thursday.week7.hagyoung99;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Q10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(in.readLine());
        int[] arr = new int[k];
        for(int i=0;i<k;i++) arr[i] = Integer.parseInt(in.readLine());

        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int x:arr){
            if(x!=0) st.push(x);
            else st.pop();
        }
        for(int i=0;i<st.size();i++) answer += st.get(i);
        System.out.println(answer);
    }
}
