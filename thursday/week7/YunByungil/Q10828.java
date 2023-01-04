
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10828 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        String input = "";
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            if (input.length() > 5) {
                push(stack, input);
            } else if (input.equals("empty")) {
                empty(stack);
            } else if (input.equals("top")) {
                top(stack);
            } else if (input.equals("size")) {
                size(stack);
            } else if (input.equals("pop")) {
                pop(stack);
            }
        }

        // 2. 명령어 생성
        // 메서드

        // 3. 출력
        System.out.println(sb);
    }

    public static void push(Stack stack, String input) {
        int number = Integer.parseInt(input.substring(5, input.length()));
        stack.push(number);
    }

    public static void top(Stack stack) {
        if (stack.empty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack.peek()).append("\n");
        }
    }

    public static void size(Stack stack) {
        sb.append(stack.size()).append("\n");
    }

    public static void empty(Stack stack) {
        if (stack.empty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
     }

     public static void pop(Stack stack) {
        if (stack.empty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack.peek()).append("\n");
            stack.pop();
        }
     }
}