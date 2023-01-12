package samsung01.jeensung;
import java.util.*;
public class BOJ1450 {
	static int n, c;
	static int[] arr;
	static long answer = 1;
	static boolean[] visit;
	static int t = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		c = scan.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		Arrays.sort(arr);
		int min = 0;
		int max = n - 1;
		while(min < max) {
			if(arr[max] > c) {
				max--;
				continue;
			}
			if(arr[min] > c)
				break;
			int left = min;
			int right = max;
			int ar = 1;
			int al = 1;
			while(left < right) {
				visit = new boolean[n];
				dfs(left, right, left, 0, 0, right - left + 1);
				int r = arr[right];
				int l = arr[left];
				ar = 1;
				al = 1;
				while(left< right) {
					if(arr[right--] == r)
						ar++;
					else break;
				}
				while(left < right) {
					if(arr[left++] == l)
						al++;
					else break;
				}
			}
			max-= al;
			min+= ar;
			answer *= al * ar;
		}
		System.out.println(answer);
	}
	static void dfs(int start, int end, int m, int sum, int count, int s) {
		if(sum > c)
			return;
		if(count == s) {
			answer++;
			return;
		}
		for(int i = m; i <= end; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(start + 1, end, i, sum + arr[i], count + 1, s);
				visit[i] = false;
			}
		}
		
	}
}
