package jeensung;

import java.util.*;
public class BOJ1874{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        //n¹ø ¹Ýº¹
        while(n-- > 0) {

            int value = scan.nextInt();
            if(value > start) {
                for(int i = start + 1; i <= value; i++){
                    stack.push(i); 
                     sb.append('+').append('\n');  
                }
                start = value;
            }else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }

}