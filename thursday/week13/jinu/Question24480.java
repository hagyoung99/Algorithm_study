package thursday.week13.jinu;

import java.io.*;
import java.util.*;

// 4480번 알고리즘 수업 - 깊이 우선 탐색 2(https://www.acmicpc.net/problem/24480) 
public class Question24480 {

    static int N, M, R, cnt = 1;

    // 그래프에 대한 정보를 ArrayList<Integer>에 저장
    static ArrayList<Integer> list[];
    static int[] visited; // 방문 확인 배열

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            list[i].sort(Comparator.reverseOrder());
        }
        DFS(R);
        for (int i = 1; i <= N; i++) {

            // BFS탐색이 종료한 뒤 순번을 결과로 출력
            System.out.println(visited[i]);
        }
    }

    private static void DFS(int start) {
        visited[start] = cnt++;

        // BFS(깊이 우선 탐색)을 이용하여 시작정점 R에서 탐색
        for (Integer d : list[start]) {
            if (visited[d] > 0)
                continue;
            DFS(d);
        }
    }

}
