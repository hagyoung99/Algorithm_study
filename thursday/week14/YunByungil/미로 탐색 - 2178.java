package 그래프와순회.실버.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain {
    public static int n, m;

    public static int[] col = {0, 0, 1, -1};
    public static int[] row = {1, -1, 0, 0};


    public static boolean[][] visit;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1][m + 1];
        arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }
        dfs();
        System.out.println(arr[n][m]);
    }

    public static void dfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 1});
        visit[1][1] = true;

        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int x = nowLocation[0];
            int y = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + col[i];
                int newY = y + row[i];
                
                if (newX > m || newY > n) {
                    continue;
                }
                
                if (visit[newY][newX] || arr[newY][newX] == 0) {
                    continue;
                }
                
                q.offer(new int[]{newX, newY});
                visit[newY][newX] = true;
                arr[newY][newX] = arr[y][x] + 1;
            }
        }
    }
}
