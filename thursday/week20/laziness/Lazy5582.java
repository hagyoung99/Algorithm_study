package thursday.week20.laziness;

import java.util.*;

public class Lazy5582 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine(), str2 = scanner.nextLine();
        int n = getSolution(str1, str2);
        System.out.println(n);
        scanner.close();
    }

    private static int getSolution(String str1, String str2) {
        int answer = 0;
        
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1 ; i <= str1.length() ; i++) {
            for(int j = 1 ; j <= str2.length() ; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer;
    }
}
