package week29;
import java.util.*;
class RR{
	int x;
	int y;
	RR(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ2660 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++) {
				if(i == j) continue;
				arr[i][j] = 100000000;
			}
		while(true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if(x == -1 && y == -1) break;
			arr[x][y] = arr[y][x] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int k = 1; k <= n; k++) {
					if(i == j) continue;
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			int temp = Integer.MIN_VALUE;
			for(int j = 1; j <= n; j++) {
				if(i == j) continue;
				temp = Math.max(temp, arr[i][j]);
			}
			list.add(temp);
		}
		List<RR> temp = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(min > list.get(i)) {
				temp = new ArrayList<>();
				temp.add(new RR(list.get(i), i + 1));
				min = list.get(i);
			}else if(min == list.get(i))
				temp.add(new RR(list.get(i), i + 1));
		}
		System.out.println(min + " " + temp.size());
		for(int i = 0; i < temp.size(); i++)
			System.out.print(temp.get(i).y + " ");
	}

}
