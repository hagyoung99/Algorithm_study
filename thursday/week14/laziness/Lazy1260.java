package thursday.week14.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lazy1260 {
    public static ArrayList<Integer>[] edges;
    public static boolean[] visitedForDfs;
    public static boolean[] visitedForBfs;
    public static StringBuffer dfs = new StringBuffer();
    public static StringBuffer bfs = new StringBuffer();
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n];
        visitedForDfs = new boolean[n];
        visitedForBfs = new boolean[n];
        for (int i = 0 ; i < n ; i++) edges[i] = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u - 1].add(v - 1);
            edges[v - 1].add(u - 1);
        }
        for(int i = 0 ; i < n ; i++) Collections.sort(edges[i]);
        dfs(r - 1);
        bfs(r);
        System.out.println(dfs);
        System.out.println(bfs);
        reader.close();
    }
    private static void bfs(int r) {
        visitedForDfs[r - 1] = true;
        bfs.append(r).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r - 1);
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for (int n : edges[num]) {
                if(!visitedForDfs[n]) {
                    visitedForDfs[n] = true;
                    bfs.append(n + 1).append(" ");
                    queue.add(n);
                }
            }
        }
    }
    private static void dfs(int r) {
        visitedForBfs[r] = true;
        dfs.append(r + 1).append(" ");
        for(int i : edges[r]) {
            if (!visitedForBfs[i]) dfs(i);
        }
    }
}