package thursday.week13.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy2606 {
    public static boolean[] visited;
    public static int[][] arr;
    public static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), k = Integer.parseInt(reader.readLine());
        visited = new boolean[n];
        arr = new int[k][2];
        for (int i = 0; i < k; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0);
        System.out.println(cnt);
        reader.close();
    }
    private static void dfs(int n) {
        visited[n] = true;
        for(int[] ar : arr) {
            if(ar[0] - 1 == n && !visited[ar[1] - 1]) {
                dfs(ar[1] - 1); cnt++;
            }
            else if (ar[1] - 1 == n && !visited[ar[0] - 1]) {
                dfs(ar[0] - 1); cnt++;
            }
        }
    }
}

