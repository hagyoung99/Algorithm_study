package BOJ.boj1446;

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
        int n = sc.nextInt();
        int d = sc.nextInt();

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < d + 1; i++) {
            graph.add(new ArrayList<>());
            if (i == d) {
                continue;
            }
            graph.get(i).add(new Node(i + 1, 1));
        }

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            if (end <= d && (end - start) >= weight) {
                graph.get(start).add(new Node(end, weight));
            }
        }

        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.add(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        System.out.println(dist[d]);
    }
}
