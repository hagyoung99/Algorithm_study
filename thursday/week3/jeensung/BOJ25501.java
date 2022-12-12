package jeensung;
import java.util.*;
public class BOJ25501 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			String str = scan.next();
			String[] arr = str.split("");
			if(arr.length % 2 == 0)
				dfs(arr, 0, arr.length - 1, 1);
			else
				dfs2(arr, 0, arr.length - 1, 1);
		}
	}
	static void dfs(String[] arr, int start, int end, int count) {
		if(start + 1 == end) {
			if(arr[start].equals(arr[end])) {
				System.out.println(1 + " " + (count + 1));
			}else 
				System.out.println(0 + " " + count);
			return;
		}
		if(!arr[start].equals(arr[end])) {
			System.out.println(0 + " " + count);
			return;
		}else
			dfs(arr, start + 1, end - 1, count + 1);
	}
	static void dfs2(String[] arr, int start, int end, int count) {
		if(start == end) {
			if(arr[start].equals(arr[end])) {
				System.out.println(1 + " " + count);
			}else 
				System.out.println(0 + " " + count);
			return;
		}
		if(!arr[start].equals(arr[end])) {
			System.out.println(0 + " " + count);
			return;
		}else
			dfs2(arr, start + 1, end - 1, count + 1);
	}
}
