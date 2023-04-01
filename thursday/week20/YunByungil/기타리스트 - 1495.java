package b전체문제.실버.기타리스트_1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class t {
    public static int n, s, m;
    public static int[] v; // 볼륨 리스트
    public static int[] dp; // dp

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n + 1];
        dp = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = -1;
        }

        dp[s] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                if (dp[j] == i - 1) {
                    int plus = j + v[i];
                    int minus = j - v[i];

                    /*
                    문제점 발견,
                    2 1 4
                    1 2 를 입력했다고 가정해보자
                    i = 1일 때, j = 0, 2를 조사해야 되는데
                    j = 0에서 조사를 하고 값을 바꿔버리니까 j = 2일 때 조사를 못하는 것임.
                     */
                    if (0 <= plus && plus <= m) {
//                        dp[plus] = i;
                        list.add(plus);
                    }

                    if (0 <= minus && minus <= m) {
                        list.add(minus);
//                        dp[minus] = i;
                    }
                }
            }

            for (Integer n : list) {
                dp[n] = i;
            }
        }
        int max = -1;


        for (int i = 0; i <= m; i++) {
            if (dp[i] == n) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
