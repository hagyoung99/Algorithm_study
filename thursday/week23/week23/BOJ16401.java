package week23;
import java.util.*;
public class BOJ16401 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			max = Math.max(max, arr[i]);
		}
		int left = 1;
		int right = max;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			for(int i = 0; i < arr.length;i++)
				count += arr[i] / mid;
			if(count >= m) {
				answer = mid;
				left = mid + 1;
			}else
				right = mid - 1;
		}
		System.out.println(answer);
	}
}
