package 그래프와순회.실버.유기농배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMian {
    public static int m, n;
    public static int count;
    public static boolean[][] visited;
    public static boolean[][] dp;

    public static int[] row = {0, 0, 1, -1};
    public static int[] col = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 t

        for (int check = 0; check < t; check++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            n = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어져있는 위치의 개수
            count = 0;


            visited = new boolean[n][m];
            dp = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dp[b][a] = true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dp[i][j] && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + col[i];
            int newY = y + row[i];
            if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                if (dp[newY][newX] && !visited[newY][newX]) {
                    dfs(newY, newX);
                }
            }
        }
    }
}
