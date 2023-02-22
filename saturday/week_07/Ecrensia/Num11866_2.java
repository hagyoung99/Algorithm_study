package silver_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num11866_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int people = Integer.parseInt(st.nextToken());
		int deleteNumber = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < people; i++) {
			queue.add(i+1);
		}
		
		int count = 0;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("<");
		
		while (queue.size() > 1) {
			count++;

			if (count != deleteNumber) {
				queue.add(queue.poll());
			} else {
				bw.append(Integer.toString(queue.poll())).append(", ");
				count = 0;
			}
		}
		
		bw.append(Integer.toString(queue.poll())).append(">");
		bw.flush();
		
	}
}
