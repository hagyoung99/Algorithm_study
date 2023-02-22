package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Num1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int length = Integer.parseInt(br.readLine());
		int index = 0;
		int count = 1;
		int[] original = new int[length];
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> popping = new ArrayList<Integer>();
		
		for(int i = 0; i < length; i++) {
			original[i] = Integer.parseInt(br.readLine());
		}
		
		while(length + 1 != count) {
				stack.push(count++);
				sb.append('+');
				sb.append(System.lineSeparator());
			while(!stack.empty() && stack.peek() == original[index] ) {
				popping.add(stack.pop());
				index++;
				sb.append('-');
				sb.append(System.lineSeparator());					
				//if(popping.size() != length) {
				//}
			}
		}
		
		if(index == count - 1) System.out.println(sb.toString());
		else System.out.println("NO");
	}
}