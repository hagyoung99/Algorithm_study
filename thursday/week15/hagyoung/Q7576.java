package thursday.week15.hagyoung;

import java.io.*;
import java.util.*;
public class Q7576 {
    static int M, N;
    static int[][] board;
    static Queue<int[]> q = new LinkedList<>();

    static int day = 0;

    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        int pullChk = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1){
                    pullChk++;
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(pullChk==M*N){
            System.out.println(0);
        } else {
            System.out.println(BFS());
        }

        
    }

    static int BFS(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i=0;i<4;i++){
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && board[nextX][nextY] == 0){
                    board[nextX][nextY] = board[x][y] + 1;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }

        int day = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==0){
                    return -1;
                }
                day = Math.max(board[i][j], day);
            }
        }
        return day-1;
    }
}
