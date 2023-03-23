package jeensung;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class BOJ2776 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t--> 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			HashSet<Integer> set = new HashSet<>();
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				set.add(arr[i]);
			}
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int[] ans = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++)
				ans[i] = Integer.parseInt(st.nextToken());
			int index = 0;
			for(int i = 0; i < m; i++) {
				if(set.contains(ans[i]))
					bw.write("1\n");
				else
					bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
