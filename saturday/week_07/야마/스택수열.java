import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<Integer>();

		ArrayList<String> array = new ArrayList<String>();
		
		int num = sc.nextInt();
		
];
		for (int i=0; i<num; i++) {
			list[i] = sc.nextInt();
		}
		
		int index = 0;
		
		for (int i=1; i<=num; i++) {
			stack.push(i);
			array.add("+");
			while (!stack.isEmpty()) {
				
        //꼭대기가 일치할때
				if (stack.peek() == list[index]) {
					stack.pop();
					array.add("-");
					index++;
				} else {
					break;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			for (String st : array) {
				System.out.println(st);
			}
		}
		
	}
}
