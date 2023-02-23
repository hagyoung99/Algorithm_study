package thursday.week15.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lazy7562 {
    public static StringBuffer sb = new StringBuffer();
    public static int[][] moves = {{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for(int test_case = 0 ; test_case < T ; test_case++) {
            int n = Integer.parseInt(reader.readLine());
            int[] start = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bfs(n, start, target);
        }
        System.out.println(sb);
        reader.close();
    }
    private static void bfs(int n, int[] start, int[] target) {
        int[][] visit = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == target[0] && cur[1] == target[1]) {
                sb.append(visit[cur[0]][cur[1]]).append("\n"); return;
            }
            for(int[] move : moves) {
                int dx = cur[0] + move[0], dy = cur[1] + move[1];
                if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
                if(visit[dx][dy] == 0) {
                    visit[dx][dy] = visit[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
    }
}
