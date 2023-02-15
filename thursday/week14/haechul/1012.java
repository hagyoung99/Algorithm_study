import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int[][] farm; // 배추밭 이차원 배열
    static int cnt; // 필요한 배추흰지렁이 수
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 방향 -> 동, 서, 남, 북

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T--> 0) {
            int M = sc.nextInt(); // 가로길이
            int N = sc.nextInt(); // 세로길이
            int K = sc.nextInt(); // 배추의 위치

            farm = new int[N][M];
            cnt = 0;
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                farm[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j] == 1) {
                        farm[i][j] = 0;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < farm.length && ny >= 0 && ny < farm[0].length && farm[nx][ny] == 1) {
                farm[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
