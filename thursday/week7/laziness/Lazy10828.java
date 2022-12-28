import java.util.*;
import java.io.*;

public class Lazy10828 {
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++) {
            String command = scanner.nextLine();
            if(command.startsWith("push")) {
                int num = Integer.parseInt(command.substring(command.indexOf(" ") + 1, command.length()));
                stack.push(num);
            } else if (command.equals("pop")) {
                if(stack.isEmpty()) writer.write("-1\n");
                else writer.write(stack.pop() + "\n");
            } else if (command.equals("size")) {
                writer.write(stack.size() + "\n");
            } else if(command.equals("empty")) {
                int num = stack.isEmpty() ? 1 : 0;
                writer.write(num + "\n");
            } else {
                if (stack.isEmpty()) writer.write("-1\n");
                else writer.write(stack.peek() + "\n");
            }
        }
        writer.flush();
        writer.close();
        scanner.close();
    }
}