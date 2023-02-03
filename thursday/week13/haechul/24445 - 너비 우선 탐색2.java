import java.util.*;

public class Main {
    public static ArrayList<Integer>[] E;
    public static int[] V;
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
        for (int i = 0; i < N + 1; i++) E[i].sort(Comparator.reverseOrder());


        bfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(V[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int r) {
        V[r] = ++cnt;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(r);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : E[u]) {
                if (V[v] == 0) {
                    V[v] = ++cnt;
                    queue.add(v);
                }
            }
        }
    }
}
