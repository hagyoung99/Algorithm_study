<<<<<<< HEAD
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ2667{
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static int n;
	public static int arr[][];
	public static boolean visit[][];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		n = scan.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - 48;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	public static void bfs(int i, int j) {
		int nx, ny;
		int ans = 1;
		queue.offer(new Point(i,j));
		visit[i][j] = true;
		while(queue.isEmpty() == false) {
			Point now;
			now = queue.poll();
			for(int k = 0; k < 4; k++) {
				nx = now.x + dx[k];
				ny = now.y + dy[k];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(arr[nx][ny] == 1 && visit[nx][ny] == false) {
						queue.offer(new Point(nx, ny));
						visit[nx][ny] = true;
						ans++;
					}
				}
			}
		}
		list.add(ans);
	}
=======
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ2667{
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static int n;
	public static int arr[][];
	public static boolean visit[][];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static Queue<Point> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		n = scan.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String str = scan.next();
			for(int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - 48;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					bfs(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	public static void bfs(int i, int j) {
		int nx, ny;
		int ans = 1;
		queue.offer(new Point(i,j));
		visit[i][j] = true;
		while(queue.isEmpty() == false) {
			Point now;
			now = queue.poll();
			for(int k = 0; k < 4; k++) {
				nx = now.x + dx[k];
				ny = now.y + dy[k];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(arr[nx][ny] == 1 && visit[nx][ny] == false) {
						queue.offer(new Point(nx, ny));
						visit[nx][ny] = true;
						ans++;
					}
				}
			}
		}
		list.add(ans);
	}
>>>>>>> 6d77b77b9ac776c10f060828fa803a090e52770f
}