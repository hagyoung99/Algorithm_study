package jeensung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576{
	public static int[] dx = {1,0,0,-1};
	public static int[] dy = {0,1,-1,0};
	public static int width,height, start_x,start_y;
	public static int count;
	public static boolean visit[][];
	public static int arr[][];
	public static ArrayList<Integer> list = new ArrayList<>();
	public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	height = scan.nextInt();
    	width = scan.nextInt();
    	arr = new int[width][height];
    	count = 0;
    	for(int i = 0; i < width; i++) {
    		for(int j = 0; j < height; j++) {
    			arr[i][j] = scan.nextInt();
    			if(arr[i][j] == 1) {
    				queue.offer(new Point(i,j));
    			}
    		}
    	}
    	System.out.println(bfs());
    }
    public static int bfs() {
    	while(!queue.isEmpty()) {
    		Point now = queue.poll();
    		int x = now.x;
    		int y = now.y;
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			if(nx >= 0 && ny >= 0 && nx < width && ny < height) {
    				if(arr[nx][ny] == 0) {
    					queue.add(new Point(nx,ny));
    					arr[nx][ny] = arr[x][y] + 1;
    				}
    			}
    		}
    	}
    	for(int i = 0; i < width; i++) {
    		for(int j = 0; j < height; j++) {
    			if(arr[i][j] == 0) {
    				return -1;
    			}
				count = Math.max(count, arr[i][j]);
    		}
    	}
    	if(count == 1)
    		return 0;
    	else
    		return count - 1;
    }
}