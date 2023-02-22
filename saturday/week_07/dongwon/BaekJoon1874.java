package stack;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1874 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j <= num; j++) {
                if (num > start) {
                    stack.push(start+1);
                    sb.append("+").append('\n');
                    start++;
                } else if (stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append('\n');
                    break;
                } else if (stack.peek() != num){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}
