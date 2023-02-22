package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num1644 {
	static boolean[] checkPrimeNumber;
	static ArrayList<Integer> PrimeNumber = new ArrayList<Integer>();
	
	static void findPrimeNumber(int num) {
		checkPrimeNumber = new boolean[num + 1];
		
		for (int i = 2; i < checkPrimeNumber.length; i++) {
			if (checkPrimeNumber[i] == false) {
				PrimeNumber.add(i);
				
				for (int j = i * 2; j < checkPrimeNumber.length; j += i) {
					checkPrimeNumber[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		findPrimeNumber(num);
		PrimeNumber.add(0);
		
		int pointer1 = 0;
		int pointer2 = 0;
		int sum = 0;
		int count = 0;
		
		while (pointer2 < PrimeNumber.size()) {
			if (sum == num) {
				count++;
				sum -= PrimeNumber.get(pointer1);
				pointer1++;					
			} else {
				if (sum < num) {
					sum += PrimeNumber.get(pointer2);
					pointer2++;
				} else {
					sum -= PrimeNumber.get(pointer1);
					pointer1++;
				}
			}
		}
		
		System.out.println(count);
	}
}
