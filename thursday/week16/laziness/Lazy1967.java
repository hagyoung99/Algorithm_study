package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lazy1967 {
    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        list = new ArrayList[n + 1];
        for(int i = 1 ; i < n + 1 ; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < n - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        for(int i = 1; i <= n ; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);
    }
    private static void dfs(int x, int len) {
        for(Node node : list[x]) {
            if(!visited[node.data]) {
                visited[node.data] = true;
                dfs(node.data, len + node.cost);
            }
        }
        max = Math.max(len, max);
    }
}
class Node {
    int data;
    int cost;
    public Node(int data, int cost) {
        this.data = data;
        this.cost = cost;
    }
}
