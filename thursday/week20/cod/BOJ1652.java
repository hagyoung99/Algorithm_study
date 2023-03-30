package cod;
import java.util.*;
public class BOJ1652 {
	static int n;
	static char[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new char[n][n];
		for(int i = 0; i < n; i++)
			arr[i] = scan.next().toCharArray();
		int answer = 0;
		int temp = 0;
		for(int i = 0; i < n; i++) {
			boolean isOk = false;
			for(int j = 1; j < n; j++) {
				if(!isOk && arr[i][j - 1] == '.' && arr[i][j] == '.') {
					answer++;
					isOk = true;
				}else if(arr[i][j] == 'X')
					isOk = false;
			}
		}
		for(int i = 0; i < n; i++) {
			boolean isOk = false;
			for(int j = 1; j < n; j++) {
				if(!isOk && arr[j - 1][i] == '.' && arr[j][i] == '.') {
					temp++;
					isOk = true;
				}else if(arr[j][i] == 'X')
					isOk = false;
			}
		}
		System.out.println(answer + " " + temp);
	}

}
