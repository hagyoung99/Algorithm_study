package jeensung;
import java.util.*;
public class BOJ7490 {
	static int n;
	static int[] arr;
	static StringBuilder temp; 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			n = scan.nextInt();
			arr = new int[n + 1];
			for(int i = 1; i <= n; i++)
				arr[i] = i;
			temp = new StringBuilder();
			dfs(1, 1, 0, 1, "1");
			System.out.println(temp);
		}
	}
	static void dfs(int count, int num, int sum, int op, String str) {
		if(count == n) {
			sum += (num * op);
			if(sum == 0) 
				temp.append(str+"\n");
			return;
		}
		dfs(count + 1, num * 10 + arr[count + 1], sum, op, str + " " +  arr[count + 1]);
		dfs(count + 1, count + 1, sum + (num * op), 1,str+"+"+arr[count + 1]);
		dfs(count + 1, count + 1, sum + (num * op), -1, str+"-"+arr[count + 1]);
	}
}
