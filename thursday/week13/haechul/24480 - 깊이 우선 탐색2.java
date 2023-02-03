import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int[] V;
    public static ArrayList<Integer>[] E;
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt(), R = sc.nextInt();
        V = new int[N + 1];
        E = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) E[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            E[x].add(y);
            E[y].add(x);
        }
        for (int i = 0; i < N + 1; i++) E[i].sort(Collections.reverseOrder());

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(V[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r) {
        V[r] = ++cnt;
        for (Integer x : E[r]) {
            if (V[x] == 0) {
                dfs(x);
            }
        }
    }
}
