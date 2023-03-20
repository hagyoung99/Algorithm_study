package thursday.week19.laziness;

import java.io.*;
import java.util.*;

public class Lazy9372 {
    public static List<List<Integer>> flights;
    public static boolean[] visited;
    public static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            visited = new boolean[n + 1];
            flights = new ArrayList<>();
            cnt = 0;
            for(int i = 0 ; i <= n ; i++) flights.add(new ArrayList<>());

            for(int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(reader.readLine());
                int nation1 = Integer.parseInt(st.nextToken());
                int nation2 = Integer.parseInt(st.nextToken());
                flights.get(nation1).add(nation2);
                flights.get(nation2).add(nation1);
            }
            getMin();
            sb.append(cnt - 1).append("\n");
        }
        System.out.println(sb);
    }
    private static void getMin() {
        dfs(1);
    }
    private static void dfs(int nation) {
        visited[nation] = true; 
        if(remain()) cnt++;
        for(int i : flights.get(nation)) {
            if(!visited[i]) dfs(i);
        }
    }
    private static boolean remain() {
        for(boolean nation : visited) {
            if(!nation) return true;
        }
        return false;
    }
}
