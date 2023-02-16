package thursday.week14.hagyoung;

import java.io.*;
import java.util.*;
public class Q2667 {
    static int[][] arr;
    static boolean[][] visit;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    static int count = 0;
    static int number = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String[] st = br.readLine().split("");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                    count = 0;
                    number++;
                    DFS(i,j, N);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(number);
        for(int x : answer){
            System.out.println(x);
        }
    }

    static void DFS(int x, int y, int N){
        visit[x][y] = true;
        count++;

        for(int i=0;i<4;i++){
            int nowX = x + moveX[i];
            int nowY = y + moveY[i];
            if(nowX>=0 && nowX<N && nowY>=0 && nowY<N && arr[nowX][nowY]==1 && visit[nowX][nowY]==false){
                visit[nowX][nowY] = true;
                DFS(nowX, nowY, N);
            }
        }
    }
}
