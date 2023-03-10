import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) arr[i] = Integer.parseInt(reader.readLine());
        dp[1] = arr[1];
        if (n != 1) dp[2] = Math.max(arr[1] + arr[2], arr[2]);
        for(int i = 3 ; i <= n ; i++) dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        System.out.println(dp[n]);
    }
}