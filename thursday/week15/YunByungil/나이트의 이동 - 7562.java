package 그래프와순회.실버.나이트의이동_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int t; // 테스트 케이스 갯수
    public static int l; // 체스판의 한 변의 길이
    public static int n, m; // 두 수의 쌍 (시작점)
    public static int a, b; // 두 수의 쌍 (도착점)


    public static int[][] arr;
    public static boolean[][] visit;

    public static int[] col = {1, -1, 1, -1};
    public static int[] row = {2, 2, -2, -2};

    public static int[] col2 = {2, -2, 2, -2};
    public static int[] row2 = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); // 테스트 케이스

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()); // 체스판 크기

            arr = new int[l][l]; // 체스판의 크기를 2차원 배열로 생성
            visit = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(arr[a][b] - 1);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, m});
        arr[n][m] = 1;
        visit[n][m] = true;

        while (!q.isEmpty()) {
            int[] nowLocation = q.poll();
            int y = nowLocation[0];
            int x = nowLocation[1];



            for (int i = 0; i < 4; i++) {
                System.out.println("현재Y값 = " + nowLocation[0]);
                System.out.println("현재X값 = " + nowLocation[1]);
                int newY = nowLocation[0] + row[i];
                int newX = nowLocation[1] + col[i];

                if (newY < 0 || newX < 0 || newY >= l || newX >= l) {
                    continue;
                }

                if (visit[newY][newX] || arr[newY][newX] != 0) {
                    continue;
                }

                q.offer(new int[]{newY, newX});
                arr[newY][newX] = arr[y][x] + 1;
                System.out.println("newY위 아래 2칸 = " + newY);
                System.out.println("newX위 아래 2칸 = " + newX);
                visit[newY][newX] = true;
            }


            for (int i = 0; i < 4; i++) {
                System.out.println("현재Y값 = " + nowLocation[0]);
                System.out.println("현재X값 = " + nowLocation[1]);
                int newY = nowLocation[0] + row2[i];
                int newX = nowLocation[1] + col2[i];

                if (newY < 0 || newX < 0 || newY >= l || newX >= l) {
                    continue;
                }

                if (visit[newY][newX] || arr[newY][newX] != 0) {
                    continue;
                }

                q.offer(new int[]{newY, newX});
                arr[newY][newX] = arr[y][x] + 1;
                System.out.println("newY 왼 오 2칸 = " + newY);
                System.out.println("newX 왼 오 2칸 = " + newX);
                visit[newY][newX] = true;
            }
            System.out.println("\"ok\" = " + "ok");
        }

    }
}
