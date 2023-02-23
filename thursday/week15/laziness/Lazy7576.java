package thursday.week15.laziness;

import java.io.*;
import java.util.*;

public class Lazy7576 {
 
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
 
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
 
        int[][] arr = new int[n][m];
 
        for (int i = 0; i < n; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bfs(arr, n, m);
    }
 
    public static void bfs(int[][] arr, int n, int m) {
        Queue<Dot> q = new LinkedList<>();
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) q.add(new Dot(i, j));
            }
        }
 
        while (!q.isEmpty()) {
            Dot dot = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];
 
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (arr[nextX][nextY] != 0) continue;
                arr[nextX][nextY] = arr[dot.x][dot.y] + 1;
                q.add(new Dot(nextX, nextY));
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        System.out.println(max - 1);
 
    }
}
 
class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
