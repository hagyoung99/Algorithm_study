package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Lazy1167 {
    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int max = 0;
    public static int data;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        list = new ArrayList[n + 1];
        for(int i = 1 ; i < n + 1 ; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 1 ; j < tmp.length - 1; j += 2) list[tmp[0]].add(new Node(tmp[j], tmp[j + 1]));
        }
        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(data, 0);

        System.out.println(max);
    }
    private static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            data = x;
        }
        visited[x] = true;
        for (int i = 0; i < list[x].size(); i++) {
            Node node = list[x].get(i);
            if(!visited[node.data]) {
                dfs(node.data, node.cost + len);
                visited[node.data] = true;
            }
        }
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
