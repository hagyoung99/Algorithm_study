package week26;
import java.util.*;
public class BOJ3048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N1 = scan.nextInt();
		int N2 = scan.nextInt();
		int[][] arr = new int[2][N1 + N2];
		String str1 = scan.next();
		String str2 = scan.next();
		char[] ans = new char[N1 + N2];
		for(int i = 0; i < N1 + N2; i++) {
			if(i < N1) {
				ans[i] = str1.charAt(N1 - i - 1);
				arr[0][i] = i;
				arr[1][i] = 0;
			}else {
				ans[i] = str2.charAt(i - N1);
				arr[0][i] = i;
				arr[1][i] = 1;
			}
		}
		int t = scan.nextInt();
		while(t--> 0) {
			int d = arr[1][0];
			for(int i = 0; i < arr[0].length; i++) {
				if(arr[1][i] != d) {
					if(d == 0) {
						int temp = arr[0][i - 1];
						arr[0][i - 1] = arr[0][i];
						arr[0][i] = temp;
						arr[1][i - 1] = arr[1][i];
						arr[1][i] = d;
						if(i < arr[0].length - 1)
							d = arr[1][i + 1];
					}else
						d = arr[1][i];
				}
			}
		}
		String str = "";
		for(int i = 0; i < N1 + N2; i++)
			str += ans[arr[0][i]] + "";
		System.out.println(str);
	}

}
