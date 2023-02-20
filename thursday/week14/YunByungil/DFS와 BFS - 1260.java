package 그래프와순회.실버.DFS와BFS_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain3 {
    public static int n, m, v;
    public static boolean[] visit;
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 개수 n
        m = Integer.parseInt(st.nextToken()); // 간선의 개수 m
        v = Integer.parseInt(st.nextToken()); // 시작할 정점 번호 v

        visit = new boolean[n + 1];
        arr = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }

        dfs(v);
        visit = new boolean[n + 1];
        System.out.println();
        bfs();

    }

    public static void dfs(int start) {
        visit[start] = true;

        System.out.print(start + " ");

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && arr[start][i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int next = q.poll();
            System.out.print(next + " ");
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && arr[next][i]) {
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
