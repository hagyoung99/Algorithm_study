import java.util.*;

public class Lazy10773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        int result = 0;
        for(int i : stack) result += i;
        System.out.println(result);
        scanner.close();
    }
}