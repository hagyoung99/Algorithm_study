package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Num1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sizeOfDeque = Integer.parseInt(st.nextToken());
		int ext = Integer.parseInt(st.nextToken());
		
		int[] extArr = new int[ext];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < extArr.length; i++) {
			extArr[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> deque = new LinkedList<Integer>();

		for (int i = 1; i < sizeOfDeque + 1; i++) {
			deque.add(i);
		}
		
		int mid;
		int target;
		int count = 0;
		
		for (int i = 0; i < extArr.length; i++) {
			if (deque.size() % 2 == 0) {
				mid = deque.size() / 2 - 1;
			} else {
				mid = deque.size() / 2;
			}
			
			target = deque.indexOf(extArr[i]);
			
			if (target > mid) {
				for (int j = 0; j < deque.size() - target; j++) {
					deque.addFirst(deque.removeLast());
					count++;
				}
			} else {
				for (int j = 0; j < target; j++) {
					deque.addLast(deque.removeFirst());
					count++;
				}
			}
			
			deque.removeFirst();
		}
		
		System.out.println(count);		
	}
}
