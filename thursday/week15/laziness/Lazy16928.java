package thursday.week15.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lazy16928 {
    public static int[] count = new int[101];
    public static int[] map = new int[101];
    public static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n + m ; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a] = b;
        }
        int answer = bfs();
        System.out.println(answer);
        reader.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == 100) return count[cur];
            
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                
                if(100 < next || visited[next]) continue;
                
                visited[next] = true;

                if(map[next] != 0 && !visited[map[next]]) {
                    visited[map[next]] = true;
                    count[map[next]] = count[cur] + 1;
                    queue.offer(map[next]);
                } else if(map[next] == 0) {
                    count[next] = count[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}
