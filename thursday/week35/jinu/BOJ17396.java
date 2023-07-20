package thursday.week35.jinu;

import java.util.*;
import java.io.*;

public class BOJ17396 {

    static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    static List<ArrayList<Node>> list;
    static int V, E;
    static long[] distance;
    static boolean[] isVisited;
    static int[] isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        distance = new long[V];
        isVisited = new boolean[V];
        isPossible = new int[V];

        Arrays.fill(distance, Long.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
            isPossible[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        dijkstra(0);

        if (distance[V - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distance[V - 1]);
        }

    }

    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.end;

            if (!isVisited[current]) {
                isVisited[current] = true;

                for (Node node : list.get(current)) {

                    if (!isVisited[node.end] && distance[node.end] > distance[current] + node.weight
                            && isPossible[current] == 0) {
                        distance[node.end] = distance[current] + node.weight;
                        pq.add(new Node(node.end, distance[node.end]));
                    }

                }

            }
        }

    }

}
