package thursday.week20.jinu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question1495 {
    public static int n, s, m, vol[], dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line[] = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);
        m = Integer.parseInt(line[2]);
        vol = new int[n];
        dp = new int[n][m + 1];

        line = in.readLine().split(" ");
        for (int i = 0; i < n; i++)
            vol[i] = Integer.parseInt(line[i]);

        // 첫번째 곡은 초기 볼륨을 이용해 먼저 계산
        if (s + vol[0] <= m)
            dp[0][s + vol[0]] = 1;
        if (s - vol[0] >= 0)
            dp[0][s - vol[0]] = 1;

        // 두번째 곡부터 계산
        for (int i = 1; i < n; i++)
            calc(i);

        out.write(getMaxVol() + "");
        out.close();
        in.close();
    }

    // dp[cur][0~M]을 계산함
    private static void calc(int cur) {
        int i, changeVol = vol[cur], prev = cur - 1;
        for (i = 0; i <= m; i++)
            if (dp[prev][i] == 1) {
                if (i + changeVol <= m)
                    dp[cur][i + changeVol] = 1;
                if (i - changeVol >= 0)
                    dp[cur][i - changeVol] = 1;
            }
    }

    // 최종적으로 dp[N][0~M]에서 값이 1인 가장 큰 M을 찾음
    private static int getMaxVol() {
        for (int i = m; i >= 0; i--)
            if (dp[n - 1][i] == 1)
                return i;
        return -1; // 전부 0이면 -1리턴
    }
}