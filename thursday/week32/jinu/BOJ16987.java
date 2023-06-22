package jinu;

import java.util.*;
import java.io.*;

public class BOJ16987 {

    static int N;
    static int[] dura;
    static int[] weight;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dura = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dura[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        System.out.println(max);
    }

    static void bt(int idx, int cnt) {

        if (idx == N) {
            max = Math.max(max, cnt);
            return;
        }

        if (dura[idx] <= 0 || cnt == N - 1) {
            bt(idx + 1, cnt);
            return;
        }

        int nCnt = cnt;

        for (int i = 0; i < N; i++) {

            if (i == idx) {
                continue;
            }
            if (dura[i] <= 0) {
                continue;
            }

            hitEgg(idx, i);

            if (dura[idx] <= 0) {
                cnt++;
            }

            if (dura[i] <= 0) {
                cnt++;
            }

            bt(idx + 1, cnt);

            recoveryEgg(idx, i);
            cnt = nCnt;
        }

    }

    static void hitEgg(int handEgg, int targetEgg) {
        dura[targetEgg] -= weight[handEgg];
        dura[handEgg] -= weight[targetEgg];
    }

    static void recoveryEgg(int handEgg, int targetEgg) {
        dura[targetEgg] += weight[handEgg];
        dura[handEgg] += weight[targetEgg];
    }
}
