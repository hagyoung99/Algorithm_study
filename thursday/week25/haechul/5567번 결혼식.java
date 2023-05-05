package BOJ.boj5567;

import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[v + 1];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            visited[cur.x] = true;
            if (cur.y == 2) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.x).size(); i++) {
                int temp = graph.get(cur.x).get(i);
                if (!visited[temp]) {
                    q.add(new Point(temp, cur.y + 1));
                }
            }
        }
        int cnt = -1;
        for (boolean visit : visited) {
            if (visit) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
