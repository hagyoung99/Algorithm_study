import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        int n = Integer.parseInt(br.readLine());
        String input = "";
        for (int i = 0; i < n; i++) {
            stack = new Stack<>();
            input = br.readLine();
            vps(stack, input);
        }

        // 2. 맨 위의 값과 내 값이 다르면 지우고, 같으면 push
        // 메서드

        // 3. 출력
        System.out.println(sb);

    }

    public static void vps(Stack stack, String input) {
        char a = '(';
        char b = ')';
        for (int i = 0; i < input.length(); i++) {
            if (stack.empty()) {
                stack.push(input.charAt(i));
            } else {
                if (stack.peek().equals(a) && input.charAt(i) == a) {
                    stack.push(a);
                } else if (stack.peek().equals(b) && input.charAt(i) == b) {
                    stack.push(b);
                } else if (stack.peek().equals(a) && input.charAt(i) == b) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(i));
                }
            }
        }

        if (stack.empty()) {
            sb.append("YES").append("\n");
        } else {
            sb.append("NO").append("\n");
        }
    }
}