package BOJ.boj17396;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 분기점의 수
        int m = sc.nextInt(); // 길의 수

        boolean[] points = new boolean[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt() == 1 ? false : true;
        }

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        boolean[] visited = new boolean[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.weight, o2.weight));
        pq.add(new Node(0, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.to] || visited[cur.to]) continue;
            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);
                if (cur.to != n - 1 && !points[cur.to]) continue;
                if (dist[adjNode.to] > cur.weight + adjNode.weight) {
                    dist[adjNode.to] = cur.weight + adjNode.weight;
                    pq.add(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }
        System.out.println(dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1]);
    }
}
