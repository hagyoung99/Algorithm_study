import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = t.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt = 0;
                    bfs(i, j);
                    pq.add(cnt);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        cnt++;
        map[x][y] = 0;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dir[i][0];
            ny = y + dir[i][1];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 1) {
                bfs(nx, ny);
            }
        }

    }
}
