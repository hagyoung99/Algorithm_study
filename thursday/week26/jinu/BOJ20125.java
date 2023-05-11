package thursday.week26.jinu;

import java.io.*;

public class BOJ20125 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] ary = new char[1001][1001];

        int hr = -1;
        int hc = -1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                ary[i][j] = str.charAt(j);

                // 머리를 찾았으면 심장 위치 기록
                if (hr == -1 && ary[i][j] == '*') {
                    hr = i + 1;
                    hc = j;
                }
            }
        }

        int la = 0;
        int ra = 0;
        int w = 0;
        int ll = 0;
        int rl = 0;
        // 왼쪽 팔
        for (int i = hc - 1; i >= 0; i--) {
            if (ary[hr][i] == '_')
                break;

            la++;
        }

        // 오른쪽 팔
        for (int i = hc + 1; i < N; i++) {
            if (ary[hr][i] == '_')
                break;

            ra++;
        }

        // 허리
        for (int i = hr + 1; i < N; i++) {
            if (ary[i][hc] == '_')
                break;

            w++;
        }

        // 왼쪽 다리
        for (int i = hr + w + 1; i < N; i++) {
            if (ary[i][hc - 1] == '_')
                break;

            ll++;
        }

        // 오른쪽 다리

        for (int i = hr + w + 1; i < N; i++) {
            if (ary[i][hc + 1] == '_')
                break;

            rl++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(hr + 1).append(' ').append(hc + 1).append('\n');
        sb.append(la).append(' ').append(ra).append(' ').append(w).append(' ').append(ll).append(' ').append(rl);
        System.out.println(sb.toString());
    }

}