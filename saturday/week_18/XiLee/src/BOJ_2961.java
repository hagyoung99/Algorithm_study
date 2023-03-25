import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2961 {
    static int N,S,B;
    static StringTokenizer st;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int []S = new int[N];
        int []B = new int[N];
        int []dp = new int[N+1];    // 쓴맛과 신맛의 차이가 가장 작은 경우

        for(int i = 0 ; i < N ; i++){
            S[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

       Math.min(Math.abs(S[i]-B[i]),dp[i])
    }
}
