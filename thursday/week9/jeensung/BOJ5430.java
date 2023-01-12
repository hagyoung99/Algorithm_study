package samsung01.jeensung;

import java.util.*;

public class BOJ5430 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t--> 0) {
			String str = scan.next();
			int n = scan.nextInt();
			String temp = scan.next();
			temp = temp.substring(1, temp.length() - 1);
			String[] arr = temp.split(",");
			Deque<String> deque = new LinkedList<>();
			for(int i = 0; i < n; i++) 
				deque.offer(arr[i]);
			int index = 0;
			boolean flag = false;
			boolean isOk = true;
			while(index < str.length()) {
				if(str.charAt(index) == 'R') {
					flag = !flag;
				}else{
					if(deque.isEmpty()) {
						isOk = false;
						break;
					}
					if(!flag) {
						deque.pollFirst();
					}else {
						deque.pollLast();
					}
				}
				index++;
			}
			 if(isOk) {
				if(deque.isEmpty()) {
					sb.append("[]\n");
					continue;
				}
				if(!flag)
				{
					sb.append("[");
					while(deque.size()>= 2)
						sb.append(deque.pollFirst() + ",");
					sb.append(deque.pollFirst() + "]\n");
				}
				else {
					sb.append("[");
					while(deque.size()>= 2)
						sb.append(deque.pollLast() + ",");
					sb.append(deque.pollLast() + "]\n");
				}
			}else {
				sb.append("error\n");
			}
		}
		System.out.println(sb);
	}
}
