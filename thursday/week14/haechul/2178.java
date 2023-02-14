import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] maze;
    static int[][] dirs = {{0, 1}, {0, -1}, {1 , 0}, {-1, 0}}; // 동 서 남 북

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int x, int y) {
        Queue<CustomPoint> queue = new ArrayDeque<>();
        queue.add(new CustomPoint(x, y, 1));

        while (!queue.isEmpty()) {
            CustomPoint cur = queue.poll();
            if (cur.x == maze.length - 1 && cur.y == maze[0].length - 1) {
                System.out.println(cur.value);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 1) {
                    maze[nx][ny] = 0;
                    queue.add(new CustomPoint(nx, ny, cur.value + 1));
                }
            }
        }

    }
}

class CustomPoint extends Point {
    int value;
    CustomPoint(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
