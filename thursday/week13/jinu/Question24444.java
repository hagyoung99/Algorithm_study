package thursday.week13.jinu;

import java.util.*;
import java.io.*;

// 24444번 알고리즘 수업 - 너비 우선 탐색 1(https://www.acmicpc.net/problem/24444)
public class Question24444 {
    static int N, M;
    static List<List<Integer>> l = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        for (int i = 0; i <= N; i++)
            l.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            l.get(A).add(B);
            l.get(B).add(A);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(l.get(i));

        bfs(R);

        for (int i = 1; i <= N; i++)
            System.out.println(visited[i]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(start);
        visited[start] = cnt++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < l.get(a).size(); i++) {
                int nextV = l.get(a).get(i);

                if (visited[nextV] != 0)
                    continue;

                q.offer(nextV);
                visited[nextV] = cnt++;
            }
        }
    }
}
