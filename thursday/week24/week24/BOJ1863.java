package week24;
import java.util.*;;
public class BOJ1863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[50002];
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[i] = b;
		}
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i <= n; i++) {
			while(!stack.empty() && stack.peek() > arr[i]) {
				answer++;
				stack.pop();
			}
			if(!stack.empty() && stack.peek() == arr[i])
				continue;
			stack.push(arr[i]);
		}
		System.out.println(answer);
	}

}
