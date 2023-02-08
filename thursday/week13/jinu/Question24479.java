package thursday.week13.jinu;

import java.io.*;
import java.util.*;

// 24479번 알고리즘 수업 - 깊이 우선 탐색 1(https://www.acmicpc.net/problem/24479)
public class Question24479 {
    int[] answer;
    ArrayList<Integer>[] edges;
    int idx = 0;
    boolean[] v;

    private void dfs(int cur) {
        answer[cur] = ++idx;
        for (int next : edges[cur]) {
            if (v[next])
                continue;
            v[next] = true;
            dfs(next);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();
        answer = new int[n + 1];
        v = new boolean[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        for (int i = 1; i <= n; i++)
            Collections.sort(edges[i]);
        v[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(answer[i]).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Question24479().solution();
    }

}
