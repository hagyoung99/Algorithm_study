package thursday.week14.hagyoung;

import java.io.*;
import java.util.*;
public class Q2178 {
    static int[][] arr;
    static boolean[][] visit;
    static int[] moveX = new int[]{0, 1, 0, -1};
    static int[] moveY = new int[]{1, 0, -1, 0};

    static int N,M;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        BFS(0,0);
        System.out.println(arr[N-1][M-1]);
    }

    static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int now[] = q.poll();

            for(int i=0;i<4;i++){
                int nextX = now[0] + moveX[i];
                int nextY = now[1] + moveY[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visit[nextX][nextY] || arr[nextX][nextY]==0){
                    continue;
                } else {
                    q.offer(new int[] {nextX, nextY});
                    arr[nextX][nextY] = arr[now[0]][now[1]]+1;
                    visit[nextX][nextY] = true;
                }
            }
        }
    }
}
