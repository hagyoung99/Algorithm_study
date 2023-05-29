package BOJ.boj10282;

import java.util.*;

public class Main {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt(); // 컴퓨터 개수
            int d = sc.nextInt();  // 의존성 개수
            int c = sc.nextInt(); // 시작 노드

            ArrayList<ArrayList<Node>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                int to = sc.nextInt();
                int from = sc.nextInt();
                int weight = sc.nextInt();
                graph.get(from).add(new Node(to, weight));
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
            pq.add(new Node(c, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.weight > dist[cur.to]) {
                    continue;
                }

                for (int i = 0; i < graph.get(cur.to).size(); i++) {
                    Node adjNode = graph.get(cur.to).get(i);
                    if (dist[adjNode.to] > cur.weight + adjNode.weight) {
                        dist[adjNode.to] = cur.weight + adjNode.weight;
                        pq.add(new Node(adjNode.to, dist[adjNode.to]));
                    }
                }
            }
            int cnt = 0;
            int maxValue = 0;
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    maxValue = Math.max(dist[i], maxValue);
                }
            }
            System.out.println(cnt + " " + maxValue);
        }

    }
}
