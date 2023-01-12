package samsung01.jeensung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ2470 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		int min = 0;
		int max = n - 1;
		long temp = Long.MAX_VALUE;
		while(min < max) {
			long mid = arr[min] + arr[max];
			if(Math.abs(mid) < Math.abs(temp)) {
				temp = mid;
				sb = new StringBuilder();
				sb.append(arr[min] + " " + arr[max]);
			}if(mid < 0)
				min++;
			else
				max--;
		}
		System.out.println(sb);
	}

}
