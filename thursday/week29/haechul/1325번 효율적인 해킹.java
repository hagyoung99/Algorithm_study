package BOJ.boj1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        computers = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            if (computers[i] > max) {
                max = computers[i];
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (computers[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int x) {
        visited[x] = true;
        for (int next : graph.get(x)) {
            if (!visited[next]) {
                computers[next]++;
                dfs(next);
            }
        }
    }
}
