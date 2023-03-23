package thursday.week19.jinu;

import java.util.*;
import java.io.*;

public class Question5212 {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Point> q = new LinkedList<>();
    static int R, C;
    static char[][] map;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char c = arr[j];
                map[i][j] = c;
                if (c == 'X') {
                    q.add(new Point(i, j));
                }
            }
        }

        for (int i = 0, size = q.size(); i < size; i++) { // 50년만 계산하면 되므로 q size만큼만
            Point now = q.poll();
            int cnt = 0;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (map[nr][nc] == '.')
                        cnt++;
                } else
                    cnt++;
            }
            if (cnt >= 3) // 후에 카운트 되지 않도록
                map[now.r][now.c] = '-';
            else
                q.add(now);
        }

        List<Point> list = new ArrayList<>(q);

        int minR = R, maxR = 0, minC = C, maxC = 0;
        for (int i = 0, size = list.size(); i < size; i++) {
            Point now = list.get(i);
            minR = Math.min(now.r, minR);
            maxR = Math.max(now.r, maxR);
            minC = Math.min(now.c, minC);
            maxC = Math.max(now.c, maxC);
        }

        for (int i = minR; i <= maxR; i++) { // 지도 출력
            for (int j = minC; j <= maxC; j++) {
                char c = map[i][j];
                if (c == '-') { // 가라앉은 땅인 경우 바다로 출력
                    bw.write('.');
                } else {
                    bw.write(c);
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}