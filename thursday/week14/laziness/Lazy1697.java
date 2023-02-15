package thursday.week14.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lazy1697 {
    public static int n, k;
    public static int[] visited = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        reader.close();
        int cnt = bfs(n);
        System.out.println(cnt);
    }
    private static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if(num == k) return visited[num];
            if(num - 1 >= 0 && visited[num - 1] == 0) {
                visited[num - 1] = visited[num] + 1;
                queue.offer(num - 1);
            } 
            if (num + 1 <= 100000 && visited[num + 1] == 0) {
                visited[num + 1] = visited[num] + 1;
                queue.offer(num + 1);
            } 
            if (num * 2 <= 100000 && visited[num * 2] == 0) {
                visited[num * 2] = visited[num] + 1;
                queue.offer(num * 2);
            }
        }
        return -1;
    }
}