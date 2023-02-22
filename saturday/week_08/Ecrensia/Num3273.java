package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(br.readLine());
		int[] arr = new int[length];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int target = Integer.parseInt(br.readLine());
		int count = 0;
		int pointer1 = 0;
		int pointer2 = arr.length-1;
		
		while (pointer1 < pointer2) {
			int sum = arr[pointer1] + arr[pointer2];
			
			if (sum == target) {
				count++;
				pointer1++;
			} else {
				if (sum < target) {
					pointer1++;
				} else {
					pointer2--;
				}
			}
		}
		
		System.out.println(count);
	}
}
