import java.util.*;

public class Lazy1874 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(scanner.nextLine());
        scanner.close();

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for(int i = 0 ; i < n ; i++) {
            while(stack.isEmpty() || arr[i] != stack.peek()) {
                stack.push(cnt++);
                sb.append("+\n");
                if(cnt > n + 1) {
                    System.out.print("NO");
                    return;
                }
            }
            stack.pop(); sb.append("-\n");
        }
        System.out.println(sb);
    }
}