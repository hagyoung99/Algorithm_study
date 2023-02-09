package jeensung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ2606{
	static int[][] arr;
	static boolean[] visit;
	static int n;
	static int m;
    static int count;
    public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		arr = new int[101][101];
		visit = new boolean[101];
		count = 1;
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		dfs(1);
        System.out.println(count - 1);
    }
    public static void dfs(int i) {
    	visit[i] = true;
    	for(int j = 1; j <= n; j++) {
    		if(arr[i][j] == 1 && visit[j] == false) {
                count += 1;
    			dfs(j);
    		}
    	}
    }
}