package thursday.week21.jinu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int min = getMin(a, b, c, d);

        boolean[] clock_num = getClockNum();

        int answer = 0;
        for (int i = 1111; i <= min; i++) {
            if (clock_num[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean[] getClockNum() {
        boolean[] visit = new boolean[10000];

        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        int n = getMin(a, b, c, d);

                        if (!visit[n]) {
                            visit[n] = true;
                        }
                    }
                }
            }
        }

        return visit;
    }

    public static int getMin(int a, int b, int c, int d) {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, a * 1000 + b * 100 + c * 10 + d);
        min = Math.min(min, b * 1000 + c * 100 + d * 10 + a);
        min = Math.min(min, c * 1000 + d * 100 + a * 10 + b);
        min = Math.min(min, d * 1000 + a * 100 + b * 10 + c);

        return min;
    }
}