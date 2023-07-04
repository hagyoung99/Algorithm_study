package BOJ.boj6118;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 헛간의 개수
        int m = sc.nextInt(); // 길의 개수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[n + 1];
        int maxCost = 0;
        ArrayList<Integer> maxList = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.cost > maxCost) {
                maxList.clear();
                maxCost = cur.cost;
                maxList.add(cur.idx);
            } else if (cur.cost == maxCost) {
                maxList.add(cur.idx);
            }

            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                int adjNode = graph.get(cur.idx).get(i);
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(new Node(adjNode, cur.cost + 1));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int x : maxList) {
            if (x < answer) {
                answer = x;
            }
        }

        System.out.println(answer + " " + maxCost + " " + maxList.size());

    }
}
