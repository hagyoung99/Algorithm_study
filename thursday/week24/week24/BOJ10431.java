package week24;
import java.util.*;
public class BOJ10431 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		while(p --> 0) {
			int n = scan.nextInt();
			int[] arr = new int[20];
			for(int i = 0; i < 20; i++)
				arr[i] = scan.nextInt();
			int count = 0;
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < i; j++) {
					if(arr[i] < arr[j])
						count++;
				}
			}
			System.out.println(n + " " + count);
		}
	}

}
