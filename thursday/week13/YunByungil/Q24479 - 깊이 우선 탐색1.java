
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q24479 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static boolean[] visit;
    public static int[] arr;
    public static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (List<Integer> integers : list) {
            Collections.sort(integers);
        }

        dfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void dfs(int start) {
        visit[start] = true;
        arr[start] = count++;

        for (int v : list.get(start)) {
            if (!visit[v]) {
                dfs(v);
            }
        }
    }
}
