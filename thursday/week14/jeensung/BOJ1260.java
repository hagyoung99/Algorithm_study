<<<<<<< HEAD
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ1260{
	static int[][] arr;
	static boolean[] visit;
	static int n;
	static int m;
	static int start;
    public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		start = scan.nextInt();
		arr = new int[1001][1001];
		visit = new boolean[1001];
		
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		dfs(start);
		visit = new boolean[1001];
		System.out.println();
		bfs();
    }
    public static void dfs(int i) {
    	visit[i] = true;
    	System.out.print(i + " ");
    	for(int j = 1; j <= n; j++) {
    		if(arr[i][j] == 1 && visit[j] == false) {
    			dfs(j);
    		}
    	}
    }
    public static void bfs() {
    	Queue<Integer>queue = new LinkedList<Integer>();
    	queue.offer(start);
    	visit[start] = true;
    	System.out.print(start + " ");
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		for(int j = 1; j <= n; j++) {
    			if(arr[temp][j] == 1 && visit[j] == false) {
    				queue.offer(j);
    				visit[j] = true;
    				System.out.print(j + " ");
    			}
    		}
    	}
    }
=======
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ1260{
	static int[][] arr;
	static boolean[] visit;
	static int n;
	static int m;
	static int start;
    public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		start = scan.nextInt();
		arr = new int[1001][1001];
		visit = new boolean[1001];
		
		for(int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			arr[x][y] = arr[y][x] = 1;
		}
		dfs(start);
		visit = new boolean[1001];
		System.out.println();
		bfs();
    }
    public static void dfs(int i) {
    	visit[i] = true;
    	System.out.print(i + " ");
    	for(int j = 1; j <= n; j++) {
    		if(arr[i][j] == 1 && visit[j] == false) {
    			dfs(j);
    		}
    	}
    }
    public static void bfs() {
    	Queue<Integer>queue = new LinkedList<Integer>();
    	queue.offer(start);
    	visit[start] = true;
    	System.out.print(start + " ");
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		for(int j = 1; j <= n; j++) {
    			if(arr[temp][j] == 1 && visit[j] == false) {
    				queue.offer(j);
    				visit[j] = true;
    				System.out.print(j + " ");
    			}
    		}
    	}
    }
>>>>>>> 6d77b77b9ac776c10f060828fa803a090e52770f
}