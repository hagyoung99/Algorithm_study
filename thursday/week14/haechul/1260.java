import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 시작 지점

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 0; i < list.length; i++) list[i].sort(Comparator.naturalOrder());

        System.out.println(dfs(list, V));
        System.out.println(bfs(list, V));
    }

    private static String bfs(ArrayList<Integer>[] list, int v) {
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");
            for (int i : list[temp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return sb.toString();
    }

    private static String dfs(ArrayList<Integer>[] list, int v) {
        boolean[] visited = new boolean[list.length];
        StringBuilder sb = new StringBuilder();
        visited[v] = true;
        sb.append(v).append(" ");
        recursion(visited, sb, list, v);

        return sb.toString();
    }

    private static void recursion(boolean[] visited, StringBuilder sb, ArrayList<Integer>[] list, int v) {
        for (int i : list[v]) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i).append(" ");
                recursion(visited, sb, list, i);
            }
        }
    }
}
