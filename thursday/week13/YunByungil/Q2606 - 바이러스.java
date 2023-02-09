package 그래프와순회.실버.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
    public static int count = 0;
    public static int n;
    public static boolean[] visit;
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 n
        int m = Integer.parseInt(br.readLine()); // 간선의 수 m

        visit = new boolean[n + 1];
        arr = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }

        dfs(1);
        System.out.println("count = " + count);

    }

    public static void dfs(int start) {
        visit[start] = true;


        for (int i = 1; i <= n; i++) {
            if (!visit[i] && arr[start][i]) {
                count++;
                dfs(i);
            }
        }


    }
}
