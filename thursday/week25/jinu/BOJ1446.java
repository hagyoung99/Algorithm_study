package thursday.week25.jinu;

import java.io.*;
import java.util.*;

public class BOJ1446 {
    static List<int[]> list[];
    static int N, D, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        D = stoi(st.nextToken());
        list = new ArrayList[10001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            list[a].add(new int[] { b, c });
        }
        int dp[] = new int[10001];
        init(dp);
        for (int i = 0; i <= D; i++) {
            if (i != 0)
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            if (list[i].size() > 0) {
                for (int tmp[] : list[i]) {
                    int val = tmp[1];
                    int end = tmp[0];
                    if (dp[end] > dp[i] + val) {
                        dp[end] = dp[i] + val;
                    }
                }
            }

        }
        System.out.println(dp[D]);
    }

    static void init(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }
}
