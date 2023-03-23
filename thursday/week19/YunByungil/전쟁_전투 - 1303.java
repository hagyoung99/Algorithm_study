package 전체문제.실버.전쟁전투_1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int myTeam = 0;
    public static int yourTeam;
    public static int answer1 = 0;
    public static int answer2 = 0;
    public static int[] row = {-1, 1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static char[][] arr;
    public static boolean[][] visit;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            arr[i] = str.toCharArray();
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'W' && !visit[i][j]) {
                    result = bfs(j, i);
                }
                answer1 += result * result;
                myTeam = 0;
                result = 0;
            }
        }

        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'B' && !visit[i][j]) {
                    result = bfs2(j, i);
                }
                answer2 += result * result;
                myTeam = 0;
                result = 0;
            }
        }

        System.out.print(answer1 + " ");
        System.out.print(answer2);

    }

    public static int bfs(int x, int y) {
        visit[y][x] = true;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int ny = nowLocation[0];
            int nx = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int newY = ny + row[i];
                int newX = nx + col[i];

                if (newY < 0 || newY >= m || newX < 0 || newX >= n) {
                    continue;
                }

                if (!visit[newY][newX] && arr[newY][newX] == 'W') {
                    visit[newY][newX] = true;
                    q.offer(new int[]{newY, newX});
                    myTeam++;
                }
            }
        }

        return myTeam + 1;

    }
    public static int bfs2(int x, int y) {
        visit[y][x] = true;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int ny = nowLocation[0];
            int nx = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int newY = ny + row[i];
                int newX = nx + col[i];

                if (newY < 0 || newY >= m || newX < 0 || newX >= n) {
                    continue;
                }

                if (!visit[newY][newX] && arr[newY][newX] == 'B') {
//                    System.out.println("newY = " + newY);
//                    System.out.println("newX = " + newX);
//                    System.out.println("===");
                    visit[newY][newX] = true;
                    q.offer(new int[]{newY, newX});
                    myTeam++;
                }
            }
        }

        return myTeam + 1;

    }
}
