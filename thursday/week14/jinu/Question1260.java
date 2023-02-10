package thursday.week14.jinu;

import java.util.*;

// 1260번 DFS와 BFS(https://www.acmicpc.net/problem/1260)
public class Question1260 {

    static int[][] check; // 간선 연결상태
    static boolean[] checked; // 확인 여부
    static int n; // 정점
    static int m; // 간선
    static int start; // 시작정점

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        check = new int[1001][1001];
        checked = new boolean[1001];

        // 각선 연결상태 저장
        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            check[x][y] = check[y][x] = 1;
        }

        dfs(start);

        checked = new boolean[1001];
        System.out.println();

        bfs();

        sc.close();
    }

    public static void dfs(int i) {

        checked[i] = true;
        System.out.print(i + " ");

        for (int j = 1; j <= n; j++) {
            if (check[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        checked[start] = true;
        System.out.print(start + " ");

        // Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while (!queue.isEmpty()) {

            int temp = queue.poll();

            for (int j = 1; j <= n; j++) {
                if (check[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }

    }

}
