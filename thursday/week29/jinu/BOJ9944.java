package thursday.week29.jinu;

import java.io.*;
import java.util.*;

public class BOJ9944 {

    static int N, M, dotNum, min;
    static char map[][];
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        String input = "";
        while ((input = in.readLine()) != null) {
            st = new StringTokenizer(input);
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            map = new char[N][M];
            dotNum = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                String tmp = st.nextToken();
                for (int j = 0; j < M; j++) {
                    map[i][j] = tmp.charAt(j);
                    if (map[i][j] == '.') {
                        dotNum++;
                    }
                }
            }
            // dfs
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != '*') {
                        boolean visit[][] = new boolean[N][M];
                        visit[i][j] = true;
                        dfs(i, j, visit, 1, 0);
                        visit[i][j] = false;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println("Case " + String.valueOf(tc) + ": -1");
            } else {
                System.out.println("Case " + String.valueOf(tc) + ": " + min);
            }
            tc++;
        }
    }

    static void dfs(int r, int c, boolean visit[][], int dot, int edge) {
        if (dot == dotNum) {
            min = Math.min(min, edge);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int cnt = 0;
            int cr = r;
            int cc = c;
            // 깊은 복사
            while (true) {
                int nr = cr + dr[k];
                int nc = cc + dc[k];

                // 이탈하는 경우
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || map[nr][nc] == '*') {
                    break;
                }
                cr = nr;
                cc = nc;
                visit[nr][nc] = true;
                cnt++;
            }
            if (r == cr && c == cc) {
                continue;
            } else {
                dfs(cr, cc, visit, dot + cnt, edge + 1);

                for (int d = 1; d <= cnt; d++) {
                    int y = r + dr[k] * d;
                    int x = c + dc[k] * d;
                    visit[y][x] = false;
                }
            }
        }
    }

}