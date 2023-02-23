package 그래프와순회.골드.토마토3차원_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain {
    public static int m, n, h;
    public static int[][][] arr;
    public static boolean[][][] visit;

    public static int[] col = {-1, 1, 0, 0, 0, 0};
    public static int[] row = {0, 0, -1, 1, 0, 0};
    public static int[] ver = {0, 0, 0, 0, -1, 1};

    public static int lastZ, lastY, lastX;

    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        arr = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();

        int result = 0;
        result = arr[lastZ][lastY][lastX] - 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        result = -1;
                    }
                }
            }
        }
        System.out.println(result);

    }

    public static void bfs() {

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int z = point[0];
            int y = point[1];
            int x = point[2];

            for (int i = 0; i < 6; i++) {
                int newZ = z + ver[i];
                int newY = y + row[i];
                int newX = x + col[i];
                if (newZ < 0 || newY < 0 || newX < 0 || newZ >= h || newY >= n || newX >= m) {
                    continue;
                }

                if (arr[newZ][newY][newX] != 0) {
                    continue;
                }

                q.offer(new int[]{newZ, newY, newX});
                arr[newZ][newY][newX] = arr[z][y][x] + 1;
            }
            lastZ = z;
            lastY = y;
            lastX = x;
        }
    }
}
