package week26;
import java.util.*;
public class BOJ20125 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char[][] arr = new char[n][n];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++)
				arr[i][j] = str.charAt(j);
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == '*') {
					x = i + 1;
					y = j;
					break;
				}
			}
			if(x > 0)
				break;
		}
		int[] ans = new int[5];
		int length = 0;
		int a = 0;
		int b = 0;
		while(true) {
			if(length == 5)
				break;
			int count = 0;
			if(length == 0) {
				for(int i = y - 1; i >= 0; i--) {
					if(arr[x][i] == '*')
						count++;
					else
						break;
				}
				ans[length] = count;
			}else if(length == 1) {
				for(int i = y + 1; i < n; i++) {
					if(arr[x][i] == '*')
						count++;
					else
						break;
				}
				ans[length] = count;
			}else if(length == 2) {
				for(int i = x + 1; i < n; i++) {
					if(arr[i][y] == '*')
						count++;
					else {
						a = i;
						b = y;
						break;
					}
				}
				ans[length] = count;
			}else if(length == 3) {
				for(int i = a; i < n; i++) {
					if(arr[i][b - 1] == '*')
						count++;
					else
						break;
				}
				ans[length] = count;
			}else {
				for(int i = a; i < n; i++) {
					if(arr[i][b + 1] == '*')
						count++;
					else
						break;
				}
				ans[length] = count;
			}
			length++;
		}
		System.out.println(x + 1+ " " + (y + 1));
		for(int i = 0; i < 5; i++) {
			System.out.print(ans[i] +  " ");
		}
	}

}
