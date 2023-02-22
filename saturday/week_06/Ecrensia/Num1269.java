package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int setA = Integer.parseInt(st.nextToken());
		int setB = Integer.parseInt(st.nextToken());
		
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			map.put(st.nextToken(), true);
		}
		
		st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			if (map.containsKey(st.nextToken())) {
				setA--;
				setB--;
			} 
		}
		
		System.out.println(setA + setB);
	}
}
