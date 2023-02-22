package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num2164 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		
		int number = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= number; i++) {
			queue.add(i);
		}
		
		while(true) {
			if(queue.size() == 1) break;
			queue.poll();
			int temp = queue.poll();
			queue.add(temp);
		}
		
		System.out.println(queue.peek());
	}
}