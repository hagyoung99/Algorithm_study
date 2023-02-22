package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num15828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = Integer.parseInt(br.readLine());
		int num = 0;
		
		while (num != -1) {
			num = Integer.parseInt(br.readLine());
			if (num > 0 && queue.size() < size) {
				queue.offer(num);
			} else if (num == 0) {
				queue.poll();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if (queue.isEmpty()) {
			System.out.println("empty");
		} else {
			for (int temp : queue) {
				sb.append(temp + " ");
			}
			
			System.out.println(sb);
		}
	}
}
