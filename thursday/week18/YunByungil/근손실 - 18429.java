package 전체문제.실버.근손실_18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
    public static int count;
    public static int n, k;
    public static int[] arr;
    public static boolean[] visit;
    public static int weight = 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n일
        k = Integer.parseInt(st.nextToken()); // k씩 빠짐

        arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(weight, 0);
        System.out.println(count);
    }

    public static void dfs(int w, int depth) {
        if (w < 500) {
            System.out.println("w = " + w);
            return;
        }
        if (w >= 500 && depth == n) {
            System.out.println("w = " + w);
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(w + arr[i] - k, depth + 1);
                visit[i] = false;
            }
        }

    }
}

