package thursday.week14.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Lazy2178 {
    public static int n, m;
    public static int cnt = 0;
    public static int[][] arr;
    public static int[][] visited;
    public static Deque<int[]> deque = new ArrayDeque<>();
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        deque.offer(new int[] {0 , 0});
        bfs();
        reader.close();
    }
    private static void bfs() {
        while(!deque.isEmpty()) {
            int[] ints = deque.poll();
            if(ints[0] == m - 1 && ints[1] == n - 1) {
                System.out.println(visited[ints[1]][ints[0]] + 1);
                return;
            }
            for(int[] ar : directions) {
                int x = ints[0] + ar[0], y = ints[1] + ar[1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                if(visited[y][x] == 0 && arr[y][x] == 1) {
                    deque.offer(new int[]{x, y});
                    visited[y][x] = visited[ints[1]][ints[0]] + 1;
                }
            }
        }
    }
}
