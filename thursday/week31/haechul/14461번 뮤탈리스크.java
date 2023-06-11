package BOJ.boj12869;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] dir = {{9, 3, 1}, {3, 9, 1}, {9, 1, 3}, {3, 1, 9}, {1, 9, 3}, {1, 9, 3}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] scv = new int[3];
        int[][][] dp = new int[61][61][61];

        for (int i = 0; i < n; i++) {
            scv[i] = sc.nextInt();
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{scv[0], scv[1], scv[2], 0});
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[3] >= min) {
                continue;
            }
            int curDp = dp[cur[0]][cur[1]][cur[2]];
            if (curDp != 0 && curDp <= cur[3]) {
                continue;
            }
            dp[cur[0]][cur[1]][cur[2]] = cur[3];
            if (cur[0] <= 0 && cur[1] <= 0 && cur[2] <= 0) {
                min = Math.min(min, cur[3]);
                continue;
            }
            for (int i = 0; i < 6; i++) {
                q.add(new int[]{Math.max(cur[0] - dir[i][0], 0), Math.max(cur[1] - dir[i][1], 0), Math.max(cur[2] - dir[i][2], 0), cur[3] + 1});
            }


        }
        System.out.println(min);

    }
}
