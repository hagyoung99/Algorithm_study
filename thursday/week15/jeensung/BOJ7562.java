package jeensung;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562{
	public static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	public static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	public static int n, i, start_x,start_y,end_x, end_y,count;
	public static int arr[][];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	n = scan.nextInt();
    	while(n--> 0) {
    		i = scan.nextInt();
    		arr = new int[i][i];
    		for(int t = 0; t < i; t++) {
    			Arrays.fill(arr[t], -1);
    		}
    		int start_x = scan.nextInt();
    		int start_y = scan.nextInt();
    		int end_x = scan.nextInt();
    		int end_y = scan.nextInt();
    		
    		Point start = new Point(start_x, start_y);
    		
    		queue.offer(start);
    		arr[start_x][start_y] = 0;
    		
    		while(!queue.isEmpty()) {
    			if(start_x == end_x && start_y == end_y) {
    				break;
    			}
    			Point now = queue.remove();
    			int x = now.x;
    			int y = now.y;
    			for(int m = 0; m < 8; m++) {
    				int nx = x + dx[m];
    				int ny = y + dy[m];
    				if(nx >= 0 && nx < i && ny >= 0 && ny < i) {
    					if(arr[nx][ny] == -1) {
    						arr[nx][ny] = arr[x][y] + 1;
    						queue.add(new Point(nx,ny));
    					}
    				}
    			}
    		}
    		System.out.println(arr[end_x][end_y]);
    	}
    }
}