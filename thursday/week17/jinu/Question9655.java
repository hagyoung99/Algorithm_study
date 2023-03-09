package thursday.week17.jinu;

import java.util.*;
import java.io.*;

public class Question9655 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // if (n % 2 == 0) {
        // System.out.println("CY");
        // } else {
        // System.out.println("SK");
        // }

        // 문제에서는 돌을 1개 혹은 3개를 가져갈 수 있다고 한다.
        // N = 1 이면 상근이가 가져가니 dp[1] = true
        // N = 2 이면 상근이 1개 창영이 1개 따라서 dp[2] = false
        // N = 3 이면 상근이가 3개를 가져갈 수 있으니 dp[3] = true
        // N = 4 이면 상근이가 1개 혹은 3개를 가져가도 마지막엔 창영이가 1개를 가져가니 dp[4] = false
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);

        for (int i = 1; i <= n; i++) {
            if (!dp[i - 1]) {
                dp[i] = true;
            }

            if (i - 3 >= 0 && !dp[i - 3]) {
                dp[i] = true;
            }

        }

        if (dp[n]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

        bw.flush();
        bw.close();

    }

    // public static void main(String args[]) throws IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // int n = Integer.parseInt(br.readLine());

    // System.out.println(solve(n));
    // }

    // public static String solve(int num){
    // return num%2==1 ? "SK" :"CY";
    // }

}