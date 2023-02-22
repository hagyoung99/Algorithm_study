package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Num11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length() + 1; i++) {
			for (int j = i + 1; j < str.length() + 1; j++) {
				if (map.containsKey(str.substring(i, j))) {
					continue;
				} else {
					map.put(str.substring(i, j), true);
				}
			}
		}
		
		System.out.println(map.size());
	}
}
