import java.io.*;
import java.util.Stack;

public class Lazy4949 {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        while(true) {
            String str = bufferedReader.readLine();
            if(str.equals(".")) break;
            boolean isBalanced = true;
            for(String s : str.split("")) {
                if(s.equals("(")) {
                    stack.push(s);
                } else if(s.equals("[")) {
                    stack.push(s);
                } else if(s.equals("]") && (stack.isEmpty() || !(stack.pop()).equals("["))) {
                    isBalanced = false; break;
                } else if(s.equals(")") && (stack.isEmpty() || !(stack.pop()).equals("("))) {
                    isBalanced = false; break;
                }
            }
            if(stack.size() > 0) isBalanced = false;
            stack.clear();

            if(isBalanced) bufferedWriter.write("yes\n");
            else bufferedWriter.write("no\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
