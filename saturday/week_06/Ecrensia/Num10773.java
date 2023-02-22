package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num10773 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0; i < number; i++) {
			int number2 = Integer.parseInt(br.readLine());
			
			if(number2 != 0) arr.add(number2);
			else arr.remove(arr.size()-1);
		}
		
		int sum = 0;
	
		for(Integer num : arr) sum += num;
		
		System.out.println(sum);
	}
}