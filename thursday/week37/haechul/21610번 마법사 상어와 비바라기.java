package BOJ.boj21610;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 이다.
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][N];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        queue.add(new Node(N - 2, 0));
        queue.add(new Node(N - 2, 1));
        queue.add(new Node(N - 1, 0));
        queue.add(new Node(N - 1, 1));

        boolean[][] v;

        for (int i = 0; i < M; i++) {
            int di = sc.nextInt();
            int si = sc.nextInt();

            v = new boolean[N][N];

            // 모든 구름이 di 방향으로 si칸 이동한다.
            for (Node cur : queue) {
                cur.x = (N + cur.x + (dir[di - 1][0] * (si % N))) % N;
                cur.y = (N + cur.y + (dir[di - 1][1] * (si % N))) % N;
                // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
                arr[cur.x][cur.y]++;
                v[cur.x][cur.y] = true;
            }

            // 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
            // 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                for (int j = 1; j < 8; j += 2) {
                    int nx = cur.x + dir[j][0];
                    int ny = cur.y + dir[j][1];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
                    if (arr[nx][ny] > 0) {
                        arr[cur.x][cur.y]++;
                    }
                }
            }

            // 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    if (!v[a][b] && arr[a][b] >= 2) {
                        arr[a][b] -= 2;
                        queue.add(new Node(a, b));
                    }
                }
            }
        }

        // M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.
        int result = 0;
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                result += arr[p][q];
            }
        }

        System.out.println(result);
    }
}
