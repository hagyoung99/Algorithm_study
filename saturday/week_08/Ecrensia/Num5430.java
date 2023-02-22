package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Num5430 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			String func = br.readLine();
			int num = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],", false);
			ArrayDeque<String> arr = new ArrayDeque<String>();
			
			while (st.hasMoreTokens()) {
				arr.add(st.nextToken());
			}
			
			AC_Func(func, arr);
		}
		
		System.out.println(sb);
	}
	
	static void AC_Func(String str, ArrayDeque<String> arr) {
		boolean direction = true;
		
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == 'R') {
				direction = !direction;
				continue;
			}
			if (!arr.isEmpty()) {
				if (direction) {
					arr.removeFirst();
				} else {
					arr.removeLast();
				}
			} else {
				sb.append("error").append('\n');
				return;
			}
		}
		
		sb.append('[');
		
		if (arr.size() > 0) {
			if (direction) {
				sb.append(arr.removeFirst());
				
				while (!arr.isEmpty()) {
					sb.append(',').append(arr.removeFirst());
				}
			} else {
				sb.append(arr.removeLast());

				while (!arr.isEmpty()) {
					sb.append(',').append(arr.removeLast());
				}
			}	
		}
		
		sb.append(']').append('\n');
	}
}
