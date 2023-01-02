import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();

        int number = 0;
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    stack.push(number);
                }
            } else {
                stack.push(number);
            }
        }
        int stackSize = stack.size();
        int result = 0;
        for (int i = 0; i < stackSize; i++) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}