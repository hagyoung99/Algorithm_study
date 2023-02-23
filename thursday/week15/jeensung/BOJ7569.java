package jeensung;
import java.util.*;
class Point{
	int x;
	int y;
	int z;
	Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class BOJ7569{
    public static int[] dx = {1,0,0,-1,0,0};
    public static int[] dy = {0,1,-1,0,0,0};
    public static int[] dz = {0,0,0,0,-1,1};
    public static int width, height, h;
    public static int count;
    public static boolean visit[][][];
    public static int arr[][][];
    public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        height = scan.nextInt();
        width = scan.nextInt();
        h = scan.nextInt();
        count = 0;
        arr = new int[h][width][height];
        visit = new boolean[h][width][height];
        for(int k = 0; k < h; k++){
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    arr[k][i][j] = scan.nextInt();
                    if(arr[k][i][j] == 1){
                        queue.offer(new Point(k,i,j));
                        visit[k][i][j] = true;
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            int z = now.z;
            for(int i = 0; i < 6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(0 <= nx && nx < h && 0 <= ny && ny < width && 0 <= nz && nz < height){
                    if(arr[nx][ny][nz] == 0 && visit[nx][ny][nz] == false){
                        queue.offer(new Point(nx,ny,nz));
                        arr[nx][ny][nz] = arr[x][y][z] + 1;
                    }
                }
            }
        }
        for(int k = 0; k < h; k++){
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    if(arr[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if(count < arr[k][i][j]){
                        count = arr[k][i][j];
                    }
                }
            }
        }
        System.out.println(count-1);
    }
}