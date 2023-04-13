package b전체문제.골드.연구소2_17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m; // 연구소의 크기, 바이러스의 개수, 최소 시간 결과
    public static int count; // 시간 체크
    public static int result = Integer.MAX_VALUE;
    public static int mapCount;
    public static int[][] arr;
    public static int[][] arr2;
    public static boolean[][] visit;
    public static int[] row = {1, -1, 0, 0};
    public static int[] col = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        arr2 = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr2[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 11111;
                    dfs(depth + 1, i);
                    arr[i][j] = 2;
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        count = 0;
        visit = new boolean[n][n];
        arr2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr2[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 11111) {
                    visit[i][j]= true;
                    q.add(new int[]{i, j});
//                    arr2[i][j] = 1;
                }
            }
        }

        bfs2(q);
        mapCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i][j] == 0) {
                    mapCount++;
                }
            }
        }
        if (mapCount == m) {
            result = Math.min(count, result);
        }
    }

    public static void bfs2(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int nowY = nowLocation[0];
            int nowX = nowLocation[1];
//            visit[nowY][nowX] = true;

            int newY = 0;
            int newX = 0;

            for (int i = 0; i < 4; i++) {
                newY = nowY + row[i];
                newX = nowX + col[i];

                if (newY < 0 || newY >= n || newX < 0 || newX >= n) {
                    continue;
                }


                if (!visit[newY][newX] && arr2[newY][newX] != -1) {
                    int nowValue = arr2[nowY][nowX];
                    q.offer(new int[]{newY, newX});
                    visit[newY][newX] = true;
                    arr2[newY][newX] = nowValue + 1;
                    count = nowValue + 1;
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr2[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("*****" );
    }
}
