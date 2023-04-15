import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    private static int N, M, V;
    private static int[][] adj;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new int[1000][1000];
        visited = new boolean[1000];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x][y] = adj[y][x] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(V);
    }

    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 1 ; i < N ; i++){
            if(adj[v][i] == 1 && visited[i] == false)
                dfs(i);
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);

        visited[v] = true;

        while(!q.isEmpty()){
            int k = q.poll();

            for(int i = 1; i< adj.length ; i++){
                if(adj[k][i] == 1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                    System.out.println(i + " ");
                }
            }
        }

    }
}
