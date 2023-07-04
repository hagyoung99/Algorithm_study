package BOJ.boj6497;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] parents;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);

    static class Node {
        int x;
        int y;
        int c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt(); // 집의 수
            int e = sc.nextInt(); // 길의 수

            if (n == 0 && e == 0) {
                break;
            }

            parents = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }
            int total = 0;
            for (int i = 0; i < e; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int c = sc.nextInt();
                pq.add(new Node(x, y, c));
                total += c;
            }
            int answer = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int px = find(cur.x);
                int py = find(cur.y);
                if (px == py) continue;
                union(px, py);
                answer += cur.c;
            }

            System.out.println(total - answer);
        }
    }
    public static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        if (x < y) parents[y] = parents[x];
        else parents[x] = parents[y];
    }
}
