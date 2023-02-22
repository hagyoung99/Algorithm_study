package silver_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11866 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int listSize = Integer.parseInt(st.nextToken());
		int deleteNum = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < listSize; i++) {
			arr.add(i+1);
		}
		
		int deleteNumCount = deleteNum-1;
		
		bw.write("<");
		
		while (true) {
			bw.write(Integer.toString(arr.get(deleteNumCount)));
			arr.remove(deleteNumCount);
			deleteNumCount += deleteNum-1;
			
			while (deleteNumCount >= arr.size()) {
				if (arr.size() == 0) break;
				deleteNumCount -= arr.size();
			}
			
			if (arr.size() == 0) break;
			
			bw.write(", ");
		}
		
		bw.write(">");
		bw.flush();
	}
}
