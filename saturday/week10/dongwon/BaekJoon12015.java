import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		int[] arr = new int[N];
		int[] large = new int[N];
 
 
		for (int i = 0; i < N; i++) arr[i] = in.nextInt();
    
		large[0] = arr[0];
		int length_list = 1;
		
		for (int i = 1; i < N; i++) {
 
			int key = arr[i];
			
			if (large[length_list - 1] < key) {
				length_list++;
				large[length_list - 1] = key;
			} 
			else {
				int lo = 0;
				int hi = length_list;
				while (lo < hi) {
					int mid = (lo + hi) / 2;
					
					if(large[mid] < key) {
						lo = mid + 1;
					}
					else {
						hi = mid;
					}
 
				}
				
				large[lo] = key;
			
			}
			
		}
		System.out.println(length_list);
	}
}