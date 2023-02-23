package thursday.week15.laziness;

import java.io.*;
import java.util.*;

public class Lazy2206 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; 
    public static int[][] visited;
    public static int[][] arr;
    public static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) visited[i][j] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int answer = solution(0, 0);
        System.out.println(answer);
        reader.close();
    }

    private static int solution(int x, int y) {
        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(x, y, 1, 0));
        visited[x][y] = 0;
        while(!queue.isEmpty()) {
            Dot cur = queue.poll();

            if (cur.x == n - 1 && cur.y == m - 1) return cur.cnt;

            for(int[] ar : directions) {
                int dx = cur.x + ar[0], dy = cur.y + ar[1];
                if (dx < 0 || dy < 0 || dx >= n || dy >= m) continue;

                if(visited[dx][dy] > cur.drill) {
                    if(arr[dx][dy] == 0) {
                        queue.offer(new Dot(dx, dy, cur.cnt + 1, cur.drill));
                        visited[dx][dy] = cur.drill;
                    } else if (cur.drill == 0){
                        queue.offer(new Dot(dx, dy, cur.cnt + 1, cur.drill + 1));
                        visited[dx][dy] = cur.drill + 1;
                    }
                }
            }
        }
        return -1;
    }
    private static class Dot {
        int x, y, cnt, drill;

        public Dot(int x, int y, int cnt, int drill) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.drill = drill;
        }
    }
}
