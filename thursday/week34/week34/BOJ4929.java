package week34;
import java.util.*;
public class BOJ4929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(true) {
			int x = scan.nextInt();
			if(x == 0) break;
			int[] arr = new int[x];
			for(int i = 0; i < x; i++)
				arr[i] = scan.nextInt();
			int y = scan.nextInt();
			int[] ans = new int[y];
			for(int i = 0; i < y; i++)
				ans[i] = scan.nextInt();
			
			int a = 0;
			int b = 0;
			int sum = 0;
			int i = 0;
			int j = 0;
			while(i < x && j < y) {
				if(arr[i] == ans[j]) {
					sum += Math.max(a, b);
					sum += arr[i];
					a = 0;
					b = 0;
					i++;
					j++;
				}else if(arr[i] < ans[j] && i < x)
					a += arr[i++];
				else if(arr[i] > ans[j] && j < y)
					b += ans[j++];
			}
			for(int aa = i; aa < x; aa++)
				a += arr[aa];
			for(int bb = j; bb < y; bb++)
				b += ans[bb];
			sum += Math.max(a, b);
			System.out.println(sum);
		}
	}

}
