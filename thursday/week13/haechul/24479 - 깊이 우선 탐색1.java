import java.util.*;

public class Main {
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int cnt;
    public static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[] V = new int[N]; // 정점 집합
        answer = new int[N + 1];
        for (int i = 0; i < N; i++) {
            V[i] = i + 1;
        }
        ArrayList<Integer>[] E = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) E[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            E[u].add(v);
            E[v].add(u);
        }
        for (int i = 1; i <= N; i++) Collections.sort(E[i]);
        visited = new boolean[N + 1];
        cnt = 0;
        visited[R] = true;
        dfs(V, E, R);
        for (int i = 1; i <= N; i++) sb.append(answer[i]).append("\n");
        System.out.println(sb);

    }

    private static void dfs(int[] v, ArrayList<Integer>[] e, int r) {
        answer[r] = ++cnt;
        for (int x : e[r]) {
            if (visited[x]) continue;
            visited[x] = true;
            dfs(v, e, x);
        }
    }
}
