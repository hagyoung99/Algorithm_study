package BOJ.boj1941;

import java.util.*;

public class Main {
    static char[][] board;
    static int answer;
    static boolean[] visited;
    static int[] checked = new int[7];
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new char[5][5];

        for (int i = 0; i < 5; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        comb(0, 0, 0);
        System.out.println(answer);
    }

    private static void comb(int cnt, int start, int dasomCnt) {
        if (cnt - dasomCnt > 3) {
            return;
        }

        if (cnt == 7) {
            visited = new boolean[7];
            bfs(checked[0] / 5, checked[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;
            checked[cnt] = i;
            comb(cnt + 1, i + 1, (board[row][col] == 'S') ? dasomCnt + 1 : dasomCnt);
        }
    }

    private static void bfs(int x, int y) {
        int n = 1;
        visited[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                int next = 5 * nr + nc;
                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && checked[k] == next) {
                        visited[k] = true;
                        n++;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        if (n == 7) {
            answer++;
        }
    }
}
