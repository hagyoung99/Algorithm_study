package thursday.week15.hagyoung;

import java.io.*;
import java.util.*;
public class Q7562 {
    static int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] moveY = {2, 1, -1, -2, -2, -1, 1, 2};
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[][] visit = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            BFS(start, end[0], end[1], arr, visit);
        }

        System.out.println(sb);
    }

    public static void BFS(int[] start, int endX, int endY, int[][] arr, int[][] visit){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visit[start[0]][start[1]] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if(x==endX && y == endY){
                sb.append(visit[x][y]-1).append("\n");
                return;
            }

            for(int i=0;i<8;i++){
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];
                if(nextX>=0 && nextY>=0 && nextX<arr.length && nextY<arr.length && visit[nextX][nextY]==0){
                    q.offer(new int[]{nextX,nextY});
                    visit[nextX][nextY] = visit[x][y]+1;
                }
            }
        }
    }
}
