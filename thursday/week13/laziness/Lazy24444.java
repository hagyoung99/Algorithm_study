package thursday.week13.laziness;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Lazy24444 {
    public static boolean[] visited;
    public static int[] ord;
    public static int idx = 1;
    public static ArrayList<Integer>[] edges;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        ord = new int[n];
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] nodes = IntStream.range(1, n + 1).toArray();
        edges = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) edges[i] = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u - 1].add(v - 1);
            edges[v - 1].add(u - 1);
        }
        for(int i = 0 ; i < n ; i++) Collections.sort(edges[i]);
        bfs(nodes, r);
        for(int i : ord) System.out.println(i);
        reader.close();
    }
    private static void bfs(int[] nodes, int r) {
        visited[r - 1] = true;
        ord[r - 1] = idx++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r - 1);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for(int n : edges[num]) {
                if(!visited[n]) {
                    visited[n] = true;
                    ord[n] = idx++;
                    queue.add(n);
                }
            }
        }
    }
}
