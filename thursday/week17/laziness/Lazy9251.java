import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = reader.readLine().toCharArray();
        char[] s2 = reader.readLine().toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for(int i = 1 ; i <= s1.length ; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if(s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[s1.length][s2.length]);
    }
}
