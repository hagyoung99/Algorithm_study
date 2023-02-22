package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon4949 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s;


        while (true) {
            s = br.readLine();

            if (s.equals(".")) break;

            sb.append(solution(s)).append('\n');
        }

        System.out.println(sb);
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            if (a == '(' || a == '[') stack.push(a);
            else if (a == ')') {
                if (stack.empty() || stack.peek() != '(') return "no";
                else stack.pop();
            } else if (a == ']') {
                if (stack.empty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }
        if (stack.empty()) return "yes";
        else return "no";
    }
}
