<<<<<<< HEAD
import java.util.*;
import java.awt.Point;
public class BOJ1012{
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int n,width,height,m;
    public static int arr[][];
    public static boolean visit[][];
    public static ArrayList<Integer> list = new ArrayList<>();
    public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        while(n--> 0){
            int count = 0;
            width = scan.nextInt();
            height = scan.nextInt();
            m = scan.nextInt();
            arr = new int[width][height];
            visit = new boolean[width][height];
            for(int i = 0; i < m; i++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                arr[x][y] = 1;
            }
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    if(arr[i][j] == 1 && visit[i][j] == false){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            list.add(count);
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void bfs(int i, int j){
        int nx, ny;
        queue.offer(new Point(i,j));
        visit[i][j] = true;
        while(!queue.isEmpty()){
            Point now;
            now = queue.poll();
            for(int k = 0; k < 4; k++){
                nx = now.x + dx[k];
                ny = now.y + dy[k];
                if(nx >= 0 && ny >= 0 && nx < width && ny < height){
                    if(arr[nx][ny] == 1 && visit[nx][ny] == false){
                        queue.offer(new Point(nx,ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
=======
import java.util.*;
import java.awt.Point;
public class BOJ1012{
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int n,width,height,m;
    public static int arr[][];
    public static boolean visit[][];
    public static ArrayList<Integer> list = new ArrayList<>();
    public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        while(n--> 0){
            int count = 0;
            width = scan.nextInt();
            height = scan.nextInt();
            m = scan.nextInt();
            arr = new int[width][height];
            visit = new boolean[width][height];
            for(int i = 0; i < m; i++){
                int x = scan.nextInt();
                int y = scan.nextInt();
                arr[x][y] = 1;
            }
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    if(arr[i][j] == 1 && visit[i][j] == false){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            list.add(count);
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void bfs(int i, int j){
        int nx, ny;
        queue.offer(new Point(i,j));
        visit[i][j] = true;
        while(!queue.isEmpty()){
            Point now;
            now = queue.poll();
            for(int k = 0; k < 4; k++){
                nx = now.x + dx[k];
                ny = now.y + dy[k];
                if(nx >= 0 && ny >= 0 && nx < width && ny < height){
                    if(arr[nx][ny] == 1 && visit[nx][ny] == false){
                        queue.offer(new Point(nx,ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
>>>>>>> 6d77b77b9ac776c10f060828fa803a090e52770f
}