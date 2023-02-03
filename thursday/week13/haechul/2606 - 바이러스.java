import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 개수
        int m = sc.nextInt(); // 간선 개수

        int[][] network = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network[a][b] = 1;
            network[b][a] = 1;
        }

        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        visited[1] = true;
        int cnt = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (network[node][i] == 1 && !visited[i]) {
                    stack.push(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}
