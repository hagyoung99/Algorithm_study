package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int[] arr = new int[length + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int pointer1 = 0;
		int pointer2 = 0;
		int result = length + 1;
		int sum = 0;
		
		while (pointer2 < arr.length) {
			if (sum >= target) {
				if (result > pointer2 - pointer1) {
					result = pointer2 - pointer1;					
				}
				sum -= arr[pointer1];
				pointer1++;
			} else {
				sum += arr[pointer2];
				pointer2++;
			}
		}
		
		if (result == length + 1) {
			System.out.println("0");
		} else {
			System.out.println(result);			
		}
	}
}
