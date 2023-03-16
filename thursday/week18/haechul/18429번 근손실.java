package BOJ.boj18429;

import java.util.Scanner;

public class Main {
    static int n, k;
    static int cnt = 0;
    static int[] kit;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[n];
        kit = new int[n];
        for (int i = 0; i < n; i++) {
            kit[i] = sc.nextInt();
        }
        dfs(0, 500);
        System.out.println(cnt);
    }

    private static void dfs(int depth, int weight) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (weight - k + kit[i]) >= 500) {
                visited[i] = true;
                dfs(depth + 1, weight - k + kit[i]);
                visited[i] = false;
            }
        }
    }
}
