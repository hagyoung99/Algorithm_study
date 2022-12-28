import java.util.*;
import java.io.*;

public class Lazy9012 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < n ; i++) {
            if(isVPS(reader.readLine())) writer.write("YES\n");
            else writer.write("NO\n");
        }
        writer.flush();
        writer.close();
        scanner.close();
    }
    private static boolean isVPS(String str) {
        Stack<String> stack = new Stack<>();
        for(String s : str.split("")) {
            if(s.equals("(")) stack.push(s);
            else if(s.equals(")")){
                if(stack.isEmpty()) return false;
                else stack.pop();
            } 
        }
        return stack.isEmpty();
    }
}