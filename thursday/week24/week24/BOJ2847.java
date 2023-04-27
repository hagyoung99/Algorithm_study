package week24;
import java.util.*;
public class BOJ2847 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		int count = 0;
		for(int i = n - 1; i >= 1; i--) {
			if(arr[i] <= arr[i - 1]) {
				count += arr[i - 1] - arr[i] + 1;
				arr[i - 1] = arr[i] - 1;
			}
		}
		System.out.println(count);
	}
}
