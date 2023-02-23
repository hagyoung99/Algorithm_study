package thursday.week15.jinu;

import java.util.*;

// 7576번 토마토(https://www.acmicpc.net/problem/7576)

// 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게됨 -> 인접한 노드를 모두 탐색 -> BFS
class xy { // xy좌표 저장 클래스
    int x;
    int y;

    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Question7576 {
    static int node[][]; // 토마토가 저장 될 2차원 배열
    static int check[][]; // 해당 토마토가 익는 일수가 저장 될 배열 겸 방문 배열
    static int cnt = 1;
    static int n, m;

    public static void bfs(Queue<xy> q) { // BFS메소드

        // 익은 토마토의 좌표가 큐에 저장되어 전달
        while (!q.isEmpty()) { // 이제 큐가 공백이 될 때 까지 반복
            int x = q.peek().x; // 큐에 저장되어 있는 객체에서 x,y좌표를 저장
            int y = q.peek().y;
            q.poll(); // 큐에서 peek후 저장한 것이기 때문에 별도이 poll()수행으로 해당 객체 소멸

            // 아래의 조건문은 DFS게시글에서 사용한 조건문과 동일
            if (y < node[x].length - 1 && check[x][y + 1] == 0) {
                check[x][y + 1] = check[x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                q.offer(new xy(x, y + 1)); // 인접한 점을 큐에 넣어줌
                // 아래는 모두 이와 동일
            }
            if (x < node.length - 1 && check[x + 1][y] == 0) {
                check[x + 1][y] = check[x][y] + 1;
                q.offer(new xy(x + 1, y));
            }
            if (x > 0 && check[x - 1][y] == 0) {
                check[x - 1][y] = check[x][y] + 1;
                q.offer(new xy(x - 1, y));
            }
            if (y > 0 && check[x][y - 1] == 0) {
                check[x][y - 1] = check[x][y] + 1;
                q.offer(new xy(x, y - 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<xy> queue = new LinkedList<>(); // 익은 토마토의 좌표가 저장 될 큐
        m = sc.nextInt();
        n = sc.nextInt();
        node = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                node[i][j] = sc.nextInt();
            }
        }
        // ------------------------입력부 끝---------------
        for (int i = 0; i < n; i++) { // 토마토를 모두 탐색해 익은 토마토를 큐에 저장
            for (int j = 0; j < m; j++) {
                if (node[i][j] == 1 && check[i][j] == 0) {
                    queue.add(new xy(i, j));
                    check[i][j] = 1;
                }
                if (node[i][j] == -1) // 상한 토마토는 익을 수 없기 때문에 check배열에 역시 -1로 저장
                    check[i][j] = -1;

            }

        }

        sc.close();

        bfs(queue); // BFS 메소드에 큐 전달
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) { // 완성된 check배열을 탐색
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) { // check배열에 0이 한개라도 존재하면 모두 익을 수 없는 경우
                    System.out.println("-1");
                    return;
                }
                if (check[i][j] > max) { // 시작일수가 1이므로 max값을 찾음
                    max = check[i][j];
                }

            }

        }

        System.out.println(max - 1); // -1을 해주면 모두 익는데 소모되는 일수가 나옴
    }

}