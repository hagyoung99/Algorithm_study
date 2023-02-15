package thursday.week14.hagyoung;

import java.io.*;
import java.util.*;
public class Q1012 {
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    static int[][] arr;
    static boolean[][] visit;

    static int M,N;
    static int number;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            number = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visit = new boolean[M][N];
            while(K-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j] == 1 && !visit[i][j]){
                        number++;
                        DFS(i,j);
                    }
                }
            }

            sb.append(number).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i=0;i<4;i++){
            int nowX = x + moveX[i];
            int nowY = y + moveY[i];
            if(nowX>=0 && nowX<M && nowY>=0 && nowY<N && arr[nowX][nowY]==1 && visit[nowX][nowY]==false){
                visit[nowX][nowY] = true;
                DFS(nowX, nowY);
            }
        }
    }
}
