package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Num18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
		
		while (count --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
			case "push" :
				arr.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				sb.append(arr.isEmpty() ? -1 : arr.pop()).append('\n');
				break ;
			case "size" :
				sb.append(arr.size()).append('\n');
				break;
			case "empty" :
				sb.append(arr.isEmpty() ? 1 : 0).append('\n');
				break;
			case "front" :
				sb.append(arr.isEmpty() ? -1 : arr.peekFirst()).append('\n');
				break;
			case "back" :
				sb.append(arr.isEmpty() ? -1 : arr.peekLast()).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}
}
