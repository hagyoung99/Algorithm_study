package BOJ.boj16987;

import java.util.Scanner;

public class Main {
    public static int N, ans = 0;
    public static int[] S, W;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N];
        W = new int[N];
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int w = sc.nextInt();
            S[i] = s;
            W[i] = w;
        }
        solve(0);
        System.out.println(ans);

    }

    private static void solve(int now) {
        if (now == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) cnt++;
            }
            if (ans < cnt) ans = cnt;
            return;
        }
        if (S[now] <= 0) {
            solve(now + 1);
        } else {
            boolean f = false;
            for (int i = 0; i < N; i++) {
                if (i == now || S[i] <= 0) continue;
                f = true;
                S[i] -= W[now];
                S[now] -= W[i];
                solve(now + 1);
                S[i] += W[now];
                S[now] += W[i];
            }
            if (f == false) solve(now + 1);
        }
    }
}
