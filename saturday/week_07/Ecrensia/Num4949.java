package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num4949 {
	
	public static String check(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ']') {
				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();					
				}
			} else if (str.charAt(i) == ')') {
				if (stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();					
				}
			}
		}
		
		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			
			if (str.charAt(0) == '.') {
				break;
			}
			
			sb.append(check(str)).append("\n");
		}
		
		System.out.println(sb);
	}
}
