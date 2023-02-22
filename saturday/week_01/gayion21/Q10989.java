import java.io.*;

public class Q10989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		/*
		10 
		5 2 3 1 4 2 3 5 1 7
		*/

		int count[] = new int[10001];
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}

		for(int i=1; i<10001; i++) {
			while(count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}

		System.out.println(sb);
	}
}