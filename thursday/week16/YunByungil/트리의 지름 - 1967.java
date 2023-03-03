package 트리.골드.트리의지름_1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Edge {
        int location;
        int distance;

        public Edge(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }

    public static int n, maxN, answer;
    public static boolean[] visit;
    public static List<List<Edge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(num).add(new Edge(a, b));
            list.get(a).add(new Edge(num, b));
        }

        dfs(1, 0);
        visit = new boolean[n + 1];
        dfs(maxN, 0);
        System.out.println(answer);

    }

    public static void dfs(int start, int dis) {
        if (answer < dis) {
            answer = dis;
            maxN = start;
        }

        visit[start] = true;

        for (Edge edges : list.get(start)) {
            if (!visit[edges.location]) {
                dfs(edges.location, edges.distance + dis);
            }
        }
    }
}
