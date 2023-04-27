import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9079 {

    static int[][]map;
    static int n;
    static int min = Integer.MIN_VALUE;
    static BufferedReader br;
    static StringTokenizer st;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    map = new int[n][n];
    visited = new boolean[n][n];
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    int dx[4] = {0,0,-1,1};
    int dy[4] = {1,-1,0,0};

    int posX=0, posY =0;

    for(int i = 0 ; i < 4; i++){
        int nx = posX + dx[i];
        int ny = posY + dy[i];
        if(!isOverlap(map,nx,ny)) flowering(map,nx,ny);
    }


    }

    public static boolean isOverlap(int[][]map, int nx, int ny){

    }
    public static int[][] flowering(int[][]map, int nx, int ny){
        int point = map[nx][ny];
        nx
    }


}
