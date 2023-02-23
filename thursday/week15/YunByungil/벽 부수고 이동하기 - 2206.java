package 그래프와순회.골드.벽부수고이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain {
    public static int hammer, result;
    public static int n, m;

    public static int[][] arr;
    public static boolean[][][] visit;

    public static int[] col = {1, -1, 0, 0};
    public static int[] row = {0, 0, 1, -1};

    public static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

//        result = arr[n - 1][m - 1];


        if (n - 1 == 0 && m - 1 == 0) {
            System.out.println(1);
        } else {
            System.out.println(result);
        }



    }

    public static void bfs() {
        arr[0][0] = 1;
        visit[0][0][0] = true;
        visit[0][0][1] = true;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int y = nowLocation[0];
            int x = nowLocation[1];
            int crashed = nowLocation[2];

            for (int i = 0; i < 4; i++) {
                int newY = y + row[i];
                int newX = x + col[i];

                if (newY < 0 || newX < 0 || newY >= n || newX >= m) {
                    continue;
                }


                if (arr[newY][newX] == 1) {
                    if (crashed == 0 && !visit[newY][newX][1]) {
                        visit[newY][newX][crashed] = true;
                        arr[newY][newX] = arr[y][x] + 1;
                        q.offer(new int[]{newY, newX, 1});
                    }
                } else {
                    if (!visit[newY][newX][crashed]) {
                        visit[newY][newX][crashed] = true;
                        arr[newY][newX] = arr[y][x] + 1;
                        q.offer(new int[]{newY, newX, crashed});
                    }
                }

                if (newY == n - 1 && newX == m - 1) {
                    result = arr[n - 1][m - 1];
                    return;
                }
            }
        }
        result = -1;
    }
}
