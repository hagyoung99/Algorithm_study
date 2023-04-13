package jeensung;
import java.util.*;
public class BOJ2548 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] =  scan.nextInt();
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int answer = 0;
			for(int j = 0; j < n; j++)
				answer += Math.abs(arr[i] - arr[j]);
			if(min > answer) {
				list = new ArrayList<>();
				list.add(arr[i]);
				min = answer;
			}
		}
		System.out.println(list.get(0));
	}

}
