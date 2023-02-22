package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Num10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		while (count > 0) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push_front" :
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				deque.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
				break;
			case "pop_back" :
				System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
				break;
			case "size" :
				System.out.println(deque.size());
				break;
			case "empty" :
				System.out.println(deque.isEmpty() ? 1 : 0);
				break;
			case "front" :
				System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
				break;
			case "back" :
				System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
				break;
			}
			
			
			count--;
		}
	}
}
