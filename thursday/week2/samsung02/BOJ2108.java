package samsung02;
import java.util.*;
public class BOJ2108 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double sum = 0;
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int x = scan.nextInt();
			sum += x;
			arr[i] = x;
		}
		Arrays.sort(arr);
		int count = 0;
		int max = -1;
		int mid = arr[0];
		boolean isOk = false;
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			}else count = 0;
			if(max < count) {
				max = count;
				mid = arr[i];
				isOk = true;
			}else if(max == count && isOk) {
				mid = arr[i];
				isOk = false;
			}
		}
		System.out.println(Math.round(sum / n));
		System.out.println(arr[(n - 1) / 2]);
		System.out.println(mid);
		System.out.println(arr[n - 1] - arr[0]);
	}

}
