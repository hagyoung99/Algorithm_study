package jeensung;
import java.util.*;
public class BOJ12015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		int[] ans = new int[n];
		ans[0] = arr[0];
		int size = 1;
		for(int i = 1; i < n; i++) {
			if(ans[size - 1] < arr[i]) {
				ans[size++] = arr[i];
			}else {
				int temp = arr[i];
				int left = 0;
				int right = size;
				while(left < right) {
					int mid = (left + right) / 2;
					if(ans[mid] < temp) {
						left = mid + 1;
					}else
						right = mid;
				}
				ans[right] = temp;
			}
		}
		System.out.println(size);
	}

}
