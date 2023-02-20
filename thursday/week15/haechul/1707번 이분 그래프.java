package BOJ.boj1707;

import java.util.*;

public class Main {

    static int t, v, e;
    static Node[] nodes;
    static boolean[] visited;
    static boolean answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        while (t-- > 0) {
            v = sc.nextInt(); // 정점의 개수
            e = sc.nextInt(); // 간선의 개수

            nodes = new Node[v + 1];
            visited = new boolean[20001];

            for (int i = 1; i <= v; i++) nodes[i] = new Node(i);
            answer = true;
            int x, y;
            for (int i = 0; i < e; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                nodes[x].child.add(nodes[y]);
                nodes[y].child.add(nodes[x]);
            }

            for (int i = 1; i <= v; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    nodes[i].setColor(1);
                    if (!bfs(i)) {
                        answer = false;
                        break;
                    }
                }
            }
            System.out.println(answer?"YES":"NO");
        }

    }

    private static boolean bfs(int idx) {
        Queue<Node> q = new LinkedList<>();
        q.add(nodes[idx]);

        while(!q.isEmpty()) {
            Node n = q.poll();

            if (check(n)) {
                return false;
            } else {
                for (Node node : n.child) {
                    if (!visited[node.idx]) {
                        visited[node.idx] = true;
                        node.setColor(1 - n.color);
                        q.add(node);
                    }
                }
            }
        }
        return true;
    }

    private static boolean check(Node node) {
        for (Node n : node.child) {
            if (visited[n.idx] && n.color == node.color) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        int idx;
        int color;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
