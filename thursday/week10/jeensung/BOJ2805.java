package samsung01.jeensung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ2805 {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		if(n == 1) {
			if(arr[0] >= m) {
				System.out.println(arr[0] - m);
				System.exit(0);
			}
		}
		Arrays.sort(arr);
		int min = 0;
		int max = arr[n - 1];
		int answer = 0;
		while(min <= max) {
			int mid = (min + max) / 2;
			System.out.println(min + " " + max);
			if(check(min, max, mid)) {
				min = mid + 1;
			}else {
				if(check(min, max, mid - 1)) {
					answer = mid - 1;
					break;
				}else
					max = mid;
			}
		}
		if(answer < 0) answer = 0;
		System.out.println(answer);
	}
	static boolean check(int min,int max,int mid) {
		long count = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] > mid)
				count += arr[i] - mid;
			if(count >= m)
				return true;
		}
		return false;
	}
}
