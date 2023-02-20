import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N;
    static int[][] box;
    static int max = 0;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // y
        N = sc.nextInt(); // x
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(box[i][j], max);
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = temp.x + dir[i][0];
                int ny = temp.y + dir[i][1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                    q.add(new Point(nx, ny));
                    box[nx][ny] = box[temp.x][temp.y] + 1;
                }
            }
        }
    }
}
