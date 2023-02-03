
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int location = 0;

    public static int[] arr;
    public static boolean[] visit;

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];
        dfs(0, n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int now, int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = now; i < n; i++) {
            if (!visit[i]) {
                arr[depth] = i + 1;
                dfs(i, n, m, depth + 1);
            }
        }
    }
}
