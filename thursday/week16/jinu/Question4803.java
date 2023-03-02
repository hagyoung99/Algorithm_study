package thursday.week16.jinu;

import java.io.*;
import java.util.*;

// 4803번 트리(https://www.acmicpc.net/problem/4803)
public class Question4803 {

    static int N, M;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0)
                break;

            int ans = 0;
            tree = new ArrayList[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                tree[a].add(b);
                tree[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(-1, i))
                        ans++;
                }
            }

            sb.append("Case ").append(T).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            } else if (ans == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(ans).append(" trees.\n");
            }
            T++;
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean dfs(int root, int num) {
        for (int i : tree[num]) {
            if (i == root)
                continue;
            if (visited[i])
                return false;
            visited[i] = true;
            if (!dfs(num, i))
                return false;
        }
        return true;
    }

}
