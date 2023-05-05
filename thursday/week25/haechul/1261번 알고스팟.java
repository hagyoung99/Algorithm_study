package BOJ.boj1261;

import java.util.*;

public class Main {
    static class Node {
        int toX;
        int toY;
        int weight;

        public Node(int toX, int toY, int weight) {
            this.toX = toX;
            this.toY = toY;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N * M; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i - 1 >= 0) {
                    graph.get(i * M + j).add(new Node(i - 1, j, maze[i - 1][j]));
                }
                if (j - 1 >= 0) {
                    graph.get(i * M + j).add(new Node(i, j - 1, maze[i][j - 1]));
                }
                if (i + 1 < N) {
                    graph.get(i * M + j).add(new Node(i + 1, j, maze[i + 1][j]));
                }
                if (j + 1 < M) {
                    graph.get(i * M + j).add(new Node(i, j + 1, maze[i][j + 1]));
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.toX][curNode.toY] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.toX * M + curNode.toY).size(); i++) {
                Node adjNode = graph.get(curNode.toX * M + curNode.toY).get(i);
                if (dist[adjNode.toX][adjNode.toY] > adjNode.weight + curNode.weight) {
                    dist[adjNode.toX][adjNode.toY] = adjNode.weight + curNode.weight;
                    pq.add(new Node(adjNode.toX, adjNode.toY, dist[adjNode.toX][adjNode.toY]));
                }
            }

        }

        System.out.println(dist[N - 1][M - 1]);
    }
}
