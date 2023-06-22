package thursday.week31.jinu;

import java.io.*;
import java.util.*;

// 적어도
// 호텔의 고객을 정확하게 c명 모집하는 것이 아니라 c+1, c+2 ~~ c+100와도 상관이 없음
// 최소한의 비용으로 목표치를 넘어서도 상관없다
// dp [] 배열을 dp [c+1]이 아닌 dp [c+101]을 선언
//  한 번 홍보할 때 유치할 수 있는 고객의 수가 100을 넘지 않기 때문에 dp [c]가 목표치지만 가성비 도시가 있어서 dp [c]>dp [c+20] 이런 상황이 나올 수 있기 때문에 dp [c+101]으로 선언
// 배열은 큰 수로 초기화 
// 도시가 주어졌을 때 비용과 고객 수를 cost, people로 할당
// 구해진 값을 비교하여 작은 값을 선택

public class BOJ1106 {

    static int c, n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        c = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        dp = new int[c + 101];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            int cost = Integer.parseInt(s1[0]);
            int people = Integer.parseInt(s1[1]);

            for (int j = people; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }

}
