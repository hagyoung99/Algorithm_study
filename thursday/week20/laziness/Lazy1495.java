package thursday.week20.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lazy1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[51][1001];
        dp[0][s] = 1;
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 0 ; j <= m ; j++) {
                if(dp[i - 1][j] == 1) {
                    if(j + arr[i - 1] <= m) dp[i][j + arr[i - 1]] = 1;
                    if(j - arr[i - 1] >= 0) dp[i][j - arr[i - 1]] = 1;
                }
            }
        }
        System.out.println(getMax(dp, n, m));
    }

    private static int getMax(int[][] dp, int n, int m) {
        for(int i = m ; i >= 0 ; i--) {
            if(dp[n][i] == 1) return i;
        }
        return -1;
    }
}
