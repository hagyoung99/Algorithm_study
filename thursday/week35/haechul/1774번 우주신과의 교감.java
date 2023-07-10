package BOJ.boj1774;

import java.util.*;

public class Main {
    static int[] parent;

    static class Node {
        int x, y;
        double w;

        public Node(int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 우주신의 개수
        int m = sc.nextInt(); // 연결된 통로의 개수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[][] gods = new int[n + 1][2]; // 우주신들 좌표
        for (int i = 1; i <= n; i++) {
            gods[i][0] = sc.nextInt();
            gods[i][1] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.w, o2.w));

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int x1 = gods[i][0];
                int y1 = gods[i][1];
                int x2 = gods[j][0];
                int y2 = gods[j][1];

                double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

                pq.offer(new Node(i, j, dist));
            }
        }

        double result = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (union(cur.x, cur.y)) {
                result += cur.w;
            }
        }

        System.out.print(String.format("%.2f", result));
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b) {
            parent[a] = y;
            return true;
        }

        return false;
    }
}
