import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[]  = new int[10];
		int i = 0;
		
		while (N > 0) {
			arr[i] = N % 10;
			N /= 10;
			i++;
		}
		Arrays.sort(arr);
		
		for (int j = 9; j > 9-i; j--) { 
			System.out.print(arr[j]);
		}
	}
}
