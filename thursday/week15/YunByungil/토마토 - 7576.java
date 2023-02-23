package 그래프와순회.골드.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, count;
    public static int lastY, lastX;
    public static int[][] arr;
    public static boolean[][] visit;

    public static int[] col = {-1, 1, 0, 0};
    public static int[] row = {0, 0, -1, 1};
    
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[lastY][lastX] = 0;
                }
            }
        }

        System.out.println((arr[lastY][lastX] - 1));




    }
    
    public static void bfs() {
        int[] nowLocation;
        while (!q.isEmpty()) {
            nowLocation = q.poll();
            int y = nowLocation[0];
            int x = nowLocation[1];
//            visit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int newY = y + row[i];
                int newX = x + col[i];

                if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
                    continue;
                }

                if (visit[newY][newX] || arr[newY][newX] == -1 || arr[newY][newX] == 1) {
                    continue;
                }

                q.offer(new int[]{newY, newX});
                arr[newY][newX] = arr[y][x] + 1;
                visit[newY][newX] = true;

                lastY = newY;
                lastX = newX;
            }

        }
    }
}
