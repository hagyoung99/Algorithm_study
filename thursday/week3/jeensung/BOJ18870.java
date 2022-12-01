package jeensung;
import java.util.*;
public class BOJ18870 {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		int[] ans = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		ans = arr.clone();
		Arrays.sort(arr);
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int rank = 0;
		for(int i = 0; i < n; i++) {
			if(!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(hashMap.get(ans[i]) + " ");
		}
		System.out.print(sb);
	}
}
