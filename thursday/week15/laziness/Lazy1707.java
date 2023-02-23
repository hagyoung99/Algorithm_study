package thursday.week15.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lazy1707 {
    public static StringBuffer sb = new StringBuffer();
    public static List<List<Integer>> edges;
    public static int[] visited;
    public static int v, e;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            v = Integer.parseInt(st.nextToken());
            visited = new int[v];
            e = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>(); 
            for(int i = 0; i < v ; i++) edges.add(new ArrayList<>());
            for(int i = 0 ; i < e ; i++) {
                st = new StringTokenizer(reader.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());
                edges.get(e1 - 1).add(e2 - 1);
                edges.get(e2 - 1).add(e1 - 1);
            }
            bfs();
        }
        System.out.println(sb);
        reader.close();
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if(visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for(int node : edges.get(cur)) {
                    if(visited[node] == 0) queue.offer(node);
                    
                    if(visited[node] == visited[cur]) {
                        sb.append("NO").append("\n");
                        return;
                    }
                    if(visited[cur] == 1 && visited[node] == 0) visited[node] = 2;
                    else if(visited[cur] == 2 && visited[node] == 0) visited[node] = 1;
                }
            }
        }
        sb.append("YES").append("\n");
    }
}