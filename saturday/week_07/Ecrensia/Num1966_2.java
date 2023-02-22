package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1966_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		while(testCase --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int docCount = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<int[]> queue = new LinkedList<int[]>();
			int[] priority = new int[10];
			int targetPriority = 0;
			
			for (int i = 0; i < docCount; i++) {
				int temp = Integer.parseInt(st.nextToken());
				priority[temp]++;
				
				if (i == target) {
					queue.offer(new int[] {temp, 1});
					targetPriority = temp;
				} else {
					queue.offer(new int[] {temp, 0});
				}
			}
			
			System.out.println(printer(queue, priority, targetPriority));
		}
	}
	
	static int printer(Queue<int[]> queue, int[] priority, int targetPriority) {
		int count = 0;
		
		for (int i = priority.length - 1; i > 0; i--) {
			while (priority[i] > 0) {
				if(i == targetPriority && queue.peek()[1] == 1) {
					count++;
					return count;
				}
				
				if (queue.peek()[0] == i) {
					queue.poll();
					count++;
					priority[i]--;
				} else {
					queue.offer(queue.poll());
				}
			}
		}

		return 0;
	}
}