package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int see = Integer.parseInt(st.nextToken());
		int look = Integer.parseInt(st.nextToken());
		
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		for (int i = 0; i < see; i++) {
			map.put(br.readLine(), true);
		}
		
		int count = 0;
		ArrayList<String> arr = new ArrayList<String>();
		
		for (int i = 0; i < look; i++) {
			String temp = br.readLine();
			
			if(map.containsKey(temp)) {
				count++;
				arr.add(temp);
			}
		}
		
		System.out.println(count);
		Collections.sort(arr);
		
		for (String str : arr) {
			System.out.println(str);
		}
	}
}
