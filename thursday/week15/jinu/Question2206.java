package thursday.week15.jinu;

import java.util.*;
import java.io.*;

// 2206번 벽 부수고 이동하기(https://www.acmicpc.net/problem/2206) 
public class Question2206 {

    static class Loc {
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public Loc(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }

    public void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 1, false));

        int[] mi = { 0, 0, -1, 1 };
        int[] mj = { -1, 1, 0, 0 };

        boolean[][][] visited = new boolean[n][m][2];

        while (!q.isEmpty()) {
            Loc now = q.poll();

            if (now.i == n - 1 && now.j == m - 1) {
                System.out.println(now.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                    continue;

                int next_cnt = now.cnt + 1;

                if (map[ni][nj] == '0') { // 벽이 아니면
                    if (!now.destroyed && !visited[ni][nj][0]) { // 부신 벽이 여태까지 없었으면
                        q.add(new Loc(ni, nj, next_cnt, false));
                        visited[ni][nj][0] = true;
                    } else if (now.destroyed && !visited[ni][nj][1]) { // 벽을 한번 부신 적이 있으면
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }

                } else if (map[ni][nj] == '1') { // 벽이면

                    if (!now.destroyed) { // 한번도 벽을 부순적이 없다면 부순다~
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                    // 한번 부순 적이 있다면 또 부수고 갈 수 없기 때문에 pass
                }
            }

        }

        System.out.println(-1);
    }

}