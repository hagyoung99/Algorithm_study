package BOJ.boj4803;

import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = 1;
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            visited = new boolean[n + 1];

            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    cnt += isTree(i);
                }
            }

            if (cnt == 0) {
                sb.append("Case " + T++ + ": No trees.");
            } else if (cnt == 1) {
                sb.append("Case " + T++ + ": There is one tree.");
            } else {
                sb.append("Case " + T++ + ": A forest of " + cnt + " trees.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int isTree(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int node = 0, edge = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            node++;
            visited[cur] = true;

            for (int x : graph.get(cur)) {
                edge++;
                if (!visited[x]) {
                    q.offer(x);
                }
            }
        }

        return (edge / 2) + 1 == node ? 1 : 0;
    }
}
