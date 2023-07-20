package thursday.week35.jinu;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int s;
    int e;
    double weight;

    public Edge(int s, int e, double weight) {
        this.s = s;
        this.e = e;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }
}

public class BOJ1774 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] god = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            god[i][0] = Integer.parseInt(st.nextToken());
            god[i][1] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                int x1 = god[i][0];
                int y1 = god[i][1];
                int x2 = god[j][0];
                int y2 = god[j][1];

                double weight = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

                pq.add(new Edge(i, j, weight));
            }
        }

        double result = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (union(edge.s, edge.e)) {
                result += edge.weight;
            }
        }

        System.out.println(String.format("%.2f", result));

    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
            return true;
        }

        return false;
    }

}
