package jeensung;

import java.util.*;
public class BOJ7568{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] weight = new int[n];
        int[] tall = new int[n];
        for(int i = 0; i < n; i++) {
            weight[i] = scan.nextInt();
            tall[i] = scan.nextInt();
        }
        int rank;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            rank = 1;
            for(int j = 0; j < n; j++){
                if(weight[j] > weight[i] && tall[j] > tall[i]) {
                	rank++;
                }
            }
            dp[i] = rank;
        }
        for(int i = 0; i < n; i++)
            System.out.println(dp[i]);
    }
}