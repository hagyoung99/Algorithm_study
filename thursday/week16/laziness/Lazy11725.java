package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lazy11725 {
    public static int[] answer;
    public static ArrayList<Integer>[] edges;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        edges = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) edges[i] = new ArrayList<>();
        answer = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0 ; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        dfs(1);
        for(int i = 2 ; i < answer.length ; i++) System.out.println(answer[i]);
        reader.close();
    }
    private static void dfs(int i) {
        visited[i] = true;
        for(int num : edges[i]) {
            if(!visited[num]) {
                answer[num] = i;
                dfs(num);
            }
        }
    }
}
