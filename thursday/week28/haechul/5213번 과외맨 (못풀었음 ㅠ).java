package BOJ.boj5213;

import java.util.*;

public class Main {
    static int[][] tile;
    static int[][] level;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    static int n;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Node {
        int num;
        int length;
        ArrayList<Integer> path;

        public Node(int num, int length, ArrayList<Integer> path) {
            this.num = num;
            this.length = length;
            this.path = path;
        }

        void add(int i) {
            this.path.add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        tile = new int[n][2 * n];
        level = new int[n][2 * n];
        for (int i = 0; i < n * n + 1; i++) {
            v.add(new ArrayList<>());
        }

        int idx = 1;
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = 0; j < 2 * n; j++) {
                if (i % 2 == 1 && (j == 0 || j == 2 * n - 1)) {
                    continue;
                }
                tile[i][j] = sc.nextInt();
                if (k == 1) {
                    level[i][j] = idx++;
                    k = 0;
                    continue;
                }
                level[i][j] = idx;
                k++;
            }
        }

        int maxLevel = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                int cur = level[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= 2 * n) continue;
                    int next = level[nx][ny];
                    if (cur != next && tile[i][j] == tile[nx][ny]) {
                        v.get(cur).add(next);
                        v.get(next).add(cur);
                        if (next > maxLevel) {
                            maxLevel = next;
                        }
                    }
                }
            }
        }

        visited = new boolean[maxLevel + 1];

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        q.add(new Node(1,1, temp));
        visited[1] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.num == maxLevel) {
                System.out.println(cur.length);
                for (int x : cur.path) {
                    System.out.print(x + " ");
                }
                break;
            }
            for (int nx : v.get(cur.num)) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    ArrayList<Integer> tmp = new ArrayList<>(cur.path);
                    tmp.add(nx);
                    q.add(new Node(nx, cur.length + 1, tmp));
                }
            }
        }

    }
}
