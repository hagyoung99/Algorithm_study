package jeensung;

import java.util.*;
public class BOJ10773{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int n = scan.nextInt();
        int sum = 0;
        while(n-- > 0){
            int x = scan.nextInt();
            if(x != 0){
                stack.push(x);
                sum += x;
            }else if(x == 0){
                sum -= stack.peek();
                stack.pop();
            }
        }
        System.out.println(sum);
    }
}