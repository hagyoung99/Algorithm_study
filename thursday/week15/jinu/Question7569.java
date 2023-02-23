package thursday.week15.jinu;

import java.util.*;

// 

class xyz { // xy좌표 저장 클래스
    int x;
    int y;
    int z; // 면의 위치를 저장 할 변수를 하나 추가해준다.

    public xyz(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Question7569 {

    static int node[][][]; // 높이를 고려하므로 3차원으로 선언한다.
    static int check[][][];
    static int cnt = 1;
    static int n, m, h;

    public static void bfs(Queue<xyz> q) { // BFS메소드

        while (!q.isEmpty()) { // 이제 큐가 공백이 될 때 까지 반복한다.
            int x = q.peek().x; // 큐에 저장되어 있는 객체에서 x,y좌표를 저장
            int y = q.peek().y;
            int z = q.peek().z; // z좌표도 고려해준다.
            q.poll(); // 큐에서 peek후 저장한 것이기 때문에 별도이 poll()수행으로 해당 객체 소멸

            if (y < node[z][x].length - 1 && check[z][x][y + 1] == 0) { // 열의 길이 조건 주의
                check[z][x][y + 1] = check[z][x][y] + 1; // 현재 점이 가지고 있는 경로값을 인접한 점의 방문배열에 저장
                q.offer(new xyz(z, x, y + 1)); // 인접한 점을 큐에 넣어준다.
                // 아래는 모두 이와 동일

            }
            if (x < node[z].length - 1 && check[z][x + 1][y] == 0) { // 행의 길이 조건 주의
                check[z][x + 1][y] = check[z][x][y] + 1;
                q.offer(new xyz(z, x + 1, y));
            }
            if (x > 0 && check[z][x - 1][y] == 0) {
                check[z][x - 1][y] = check[z][x][y] + 1;
                q.offer(new xyz(z, x - 1, y));
            }
            if (y > 0 && check[z][x][y - 1] == 0) {
                check[z][x][y - 1] = check[z][x][y] + 1;
                q.offer(new xyz(z, x, y - 1));
            }
            // 아래 두 조건이 새롭게 추가된 2가지 조건 상, 하를 고려하는 조건문이다
            // 위의 조건문들과 다를바 없다.
            if (z < node.length - 1 && check[z + 1][x][y] == 0) {
                check[z + 1][x][y] = check[z][x][y] + 1;
                q.offer(new xyz(z + 1, x, y));
            }
            if (z > 0 && check[z - 1][x][y] == 0) {
                check[z - 1][x][y] = check[z][x][y] + 1;
                q.offer(new xyz(z - 1, x, y));
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<xyz> queue = new LinkedList<>(); // 큐
        m = sc.nextInt(); // 가로 , node[i][j].length
        n = sc.nextInt(); // 세로 , node[i].length
        h = sc.nextInt(); // 높이 , node.length
        node = new int[h][n][m];
        check = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    node[k][i][j] = sc.nextInt();
                }
            }
        }

        // 이하 코드는 이전 토마토 문제와 동일하다 반복문1개씩만 추가해주면 된다.
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (node[k][i][j] == 1 && check[k][i][j] == 0) {
                        queue.add(new xyz(k, i, j));
                        check[k][i][j] = 1;
                    }
                    if (node[k][i][j] == -1)
                        check[k][i][j] = -1;
                }
            }
        }

        sc.close();

        bfs(queue);

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check[k][i][j] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    if (check[k][i][j] > max) {
                        max = check[k][i][j];
                    }
                }
            }
        }
        System.out.println(max - 1);
    }

}
