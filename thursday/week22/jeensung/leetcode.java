
import java.util.Queue;
class Point{
	int x;
	int y;
	int cost;
	Point(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
class Solution {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visit;
	static int[][] arr;
	static int answer;
    public int maxAreaOfIsland(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        arr = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        	for(int j = 0; j < grid[0].length; j++)
        		arr[i][j] = grid[i][j];
        answer = 0;
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1 && !visit[i][j]) {
        			visit[i][j] = true;
        			answer = Math.max(bfs(i, j), answer);
        		}
        	}
        }
        return answer;
    }
    static int bfs(int x, int y) {
    	queue = new LinkedList<>();
    	int t = 1;
    	queue.offer(new Point(x, y, 1));
    	while(!queue.isEmpty()) {
    		Point now = queue.poll();
    		for(int i = 0; i < 4; i++) {
    			 int nx = now.x + dir[i][0];
    			 int ny = now.y + dir[i][1];
    			 if(nx < 0 || ny < 0 || nx >= visit.length || ny >= visit[0].length)
    				 continue;
    			 if(arr[nx][ny] == 0)
    				 continue;
    			 if(visit[nx][ny])
    				 continue;
    			 queue.offer(new Point(nx, ny, now.cost + 1));
    			 t++;
    			 visit[nx][ny] = true;
    		}
    	}
    	return t;
    }
}