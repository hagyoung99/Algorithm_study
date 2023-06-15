package thursday.week31.jinu;

import java.util.*;
import java.io.*;

public class BOJ18405 {

    static class Node {
        int x;
        int y;
        int virus;
        int time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }

    static final int[] dx = { 0, 0, -1, 1 };
    static final int[] dy = { 1, -1, 0, 0 };
    static int n, k, s;
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Node(i, j, map[i][j], 0));
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.virus - o2.virus;
            }
        });

        for (Node node : list) {
            q.add(node);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(map[x - 1][y - 1]);
    }

    static void bfs() {

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            if (now.time == s) {
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = now.virus;
                        q.add(new Node(nx, ny, now.virus, now.time + 1));
                    }
                }
            }

        }

    }

}
