package jeensung;
import java.util.*;
public class BOJ10815 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		int m = scan.nextInt();
		int[] ans = new int[m];
		int[] t = new int[500001];
		for(int i = 0; i < m; i++) 
			ans[i] = scan.nextInt();
		int[] answer = new int[m];
		Arrays.sort(arr);
		// arr : -10 2 3 6 10
		// ans : -10 -5 2 3 4 5 9 10
		for(int i = 0; i < m; i++) {
			int temp = ans[i];
			int min = 0;
			int max = n - 1;
			while(min <= max) {
				int mid = (min + max) / 2;
				if(arr[mid] < temp) {
					min = mid + 1;
				}
				else if(arr[mid] > temp) {
					max = mid - 1;
				}else {
					answer[i] = 1;
					break;
				}
			}
		}
		for(int i = 0; i < m; i++)
			System.out.print(answer[i] + " ");
	}
}
