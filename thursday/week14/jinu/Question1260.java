package thursday.week14.jinu;

import java.util.*;

// 1260번 DFS와 BFS(https://www.acmicpc.net/problem/1260)

// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고
// 더 이상 방문할 수 있는 점이 없는 경우 종료
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력
// 정점 번호(V)부터 방문된 점을 순서대로 출력
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

    // 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
    public static void dfs(int i) {

        checked[i] = true;
        // 방문하면 출력
        System.out.print(i + " ");

        for (int j = 1; j <= n; j++) {
            // 해당 위치를 방문했을 경우 해당위치를 방문하지 않을 경우
            if (check[i][j] == 1 && checked[j] == false) {
                dfs(j);
            }
        }
    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        checked[start] = true;
        // 방문하면 출력
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
