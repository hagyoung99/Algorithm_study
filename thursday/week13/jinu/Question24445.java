package thursday.week13.jinu;

import java.io.*;
import java.util.*;

// 24445번 알고리즘 수업 - 너비 우선 탐색 2](https://www.acmicpc.net/problem/24445  - 얼음
public class Question24445 {
    static int N, M, R, count = 1;

    // 그래프에 대한 정보를 ArrayList<ArrayList<Integer>>에 저장
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bfs(R);

        for (int i = 1; i <= N; i++)

            bw.write(result[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<Integer>();
        result[start] = count++;
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {

            // BFS(너비 우선 탐색)을 이용하여 시작정점 R에서 탐색
            int point = queue.poll();
            Collections.sort(graph.get(point), Collections.reverseOrder()); // 내림차순 정렬

            for (int next : graph.get(point)) {
                if (!visited[next]) {

                    visited[next] = true; //
                    result[next] = count++; //
                    queue.add(next);
                }
            }
        }
        return;
    }

}
