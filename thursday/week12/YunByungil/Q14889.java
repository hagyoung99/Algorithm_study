
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    
    public static int[][] arr;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n + 1];
        dfs(1, 0);
        System.out.println("min = " + min);
    }
    
    public static void dfs(int now, int depth) {
        if (depth == n / 2) {
            // 함수 사용
            calculate();
            return;
        }

        for (int i = now; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void calculate() {
        int start = 0;
        int link = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (visit[i] && visit[j]) {
                    start += (arr[i][j] + arr[j][i]);
                } else if (!visit[i] && !visit[j]) {
                    link += (arr[i][j] + arr[j][i]);
                }
            }
        }
        int check = Math.abs(start - link);

        min = Math.min(min, check);
    }
}
