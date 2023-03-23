package 시뮬레이션.골드.미네랄_2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int r, c, n;
    public static char[][] map;
    public static boolean[][] visit;

    public static int[] col = {1, -1, 0, 0};
    public static int[] row = {0, 0, 1, -1};

    public static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        // r x c 배열 map 생성
        for (int i = 0 ; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        // 막대기 던지기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int stick = Integer.parseInt(st.nextToken());

            breakMineral(stick, i + 1);
            bfs();

        }

        for (int i = 0 ; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void breakMineral(int height, int direction) {
        int i = r - height; // 높이
        // 홀수일 경우 (왼쪽에서 던지는 거임)
        if (direction % 2 != 0) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'x') {
                    map[i][j] = '.';
                    return;
                }
            }
        } else {
            for (int j = c - 1; j >= 0; j--) {
                if (map[i][j] == 'x') {
                    map[i][j] = '.';
                    return;
                }
            }
        }
    }

    public static void bfs() {
        visit = new boolean[r][c];
        ArrayList<Node> cluster = new ArrayList<>();

        for (int j = 0; j < c; j++) {
            if(map[r - 1][j] == '.' || visit[r - 1][j]) {
                continue;
            }

            visit[r - 1][j] = true;
            System.out.println("바닥 = " + j);
            q.add(new Node(j, r - 1));

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + col[i];
                    int newY = cur.y + row[i];

                    if (newX < 0 || newX >= c || newY < 0 || newY >= r || visit[newY][newX] || map[newY][newX] == '.') {
                        continue;
                    }

                    visit[newY][newX] = true;
                    q.add(new Node(newX, newY));
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visit[i][j] && map[i][j] == 'x') {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    map[i][j] = '.';
                    cluster.add(new Node(j, i));
                }
            }
        }

        if (cluster.isEmpty()) {
            return;
        }

        boolean down = true;
        while (down) {
            for (Node node : cluster) {
                int newX = node.x;
                int newY = node.y + 1;
                System.out.println("newY = " + newY);
                if (newX < 0 || newX >= c || newY < 0 || newY >= r || map[newY][newX] == 'x') {
                    down = false;
                    break;
                }
            }

            if (down) {
                for (Node node : cluster) {
                    node.y++;
                }
            }
        }

        for (Node node : cluster) {
            map[node.y][node.x] = 'x';
        }
    }
}
