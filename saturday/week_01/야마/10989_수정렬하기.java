import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for(int num : arr) {
			sb.append(num).append('\n');
		}

		System.out.println(sb);
	}
}
//일반정렬을 사용 + 검색참고함
