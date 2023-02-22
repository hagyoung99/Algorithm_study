package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		Loop1 :
		while (count > 0) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			if (str.charAt(0) == ')') {
				System.out.println("NO");
				count--;
				continue;
			}
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				} else {
					if (!stack.empty()) {
						stack.pop();
					} else {
						System.out.println("NO");
						count--;
						continue Loop1;
					}
				}
			}
			
			if(stack.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
			count--;
		}
	}
}
