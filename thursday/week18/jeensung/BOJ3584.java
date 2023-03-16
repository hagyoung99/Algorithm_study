package jeensung;
import java.util.*;
public class BOJ3584 {
	static int n;
	static int[] parents;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t--> 0) {
			n = scan.nextInt();
			parents = new int[n + 1];
			for(int i = 1; i <= n; i++)
				parents[i] = i;
			for(int i = 0; i < n - 1; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				parents[b] = a;
			}
			int x = scan.nextInt();
			int y = scan.nextInt();
			ArrayList<Integer> list = find(x);
			ArrayList<Integer> aList = find(y);
			int answer = 0;
			boolean[] visit = new boolean[n + 1];
			for(int i : list)
				visit[i] = true;
			for(int i : aList) {
				if(visit[i]) {
					answer = i;
					break;
				}
			}
			System.out.println(answer);
		}
		
	}
	static ArrayList<Integer> find(int x) {
		ArrayList<Integer> list = new ArrayList<>();
		int temp = x;
		list.add(temp);
		while(temp != parents[temp]) {
			list.add(parents[temp]);
			temp = parents[temp];
		}
		return list;
	}
}
