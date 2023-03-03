package BOJ.boj11725;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i < tree.length; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            tree[x].add(y);
            tree[y].add(x);
        }
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        // bfs
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer i : tree[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    parent[i] = cur;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
}
