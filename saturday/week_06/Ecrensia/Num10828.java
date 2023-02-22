package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(count > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push" :
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				System.out.println(stack.empty() ? -1 : stack.pop());
				break;
			case "size" :
				System.out.println(stack.size());
				break;
			case "empty" :
				System.out.println(stack.empty() ? 1 : 0);
				break;
			case "top" :
				System.out.println(stack.empty() ? -1 : stack.peek());
				break;
			}
			
			count--;
		}
	}
}
