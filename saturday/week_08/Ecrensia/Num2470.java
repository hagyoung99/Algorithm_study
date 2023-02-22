package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = 0;
		int max = num-1;
		int sum = 2000000000;
		
		int min_index = 0;
		int max_index = num-1;
		
		if(arr[num-1] < 0) System.out.println(arr[num-2] + " " + arr[num-1]);
		else if(arr[0] > 0) System.out.println(arr[0] + " " + arr[1]);
		else {
			while(min < max) {
				int temp = arr[min] + arr[max];
				
				if(temp == 0) {
					System.out.println(arr[min] + " " + arr[max]);
					break;
				}
				else {
					if(Math.abs(temp) < sum) {
						sum = Math.abs(temp);
						min_index = min;
						max_index = max;
					}
					if(temp < 0) min++;
					else max--;
					
					if(min == max) {
						System.out.println(arr[min_index] + " " + arr[max_index]);
					}
				}
			
			}
		}

	}
}