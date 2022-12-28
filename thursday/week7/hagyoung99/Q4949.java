package thursday.week7.hagyoung99;

import java.io.*;
import java.util.*;
public class Q4949 {
    public String solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char y : s.toCharArray()){
            if(y == '(') {
                stack.push(y);
            } else if(y=='[') {
                stack.push(y);
            } else if(y == ')' || y==']'){
                if(stack.empty()){
                    return "no";
                } else {
                    if(y==']') if(stack.peek() != '[') return "no";
                               else stack.pop();
                    else if(y==')')  if(stack.peek() != '(') return "no";
                                     else stack.pop();
                }
            }
        }
        if(!stack.empty()) return "no";
        else return "yes";
    }
    public static void main(String[] args) throws IOException{
        Q4949 main = new Q4949();
        ArrayList<String> str = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = in.readLine();
            if(s.equals(".")) break;
            str.add(main.solution(s));
        }

        for(String x:str) System.out.println(x);
    }
}
