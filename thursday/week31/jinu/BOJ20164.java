package thursday.week31.jinu;

import java.io.*;

// 적어도
// 호텔의 고객을 정확하게 c명 모집하는 것이 아니라 c+1, c+2 ~~ c+100와도 상관이 없음
// 최소한의 비용으로 목표치를 넘어서도 상관없다
// dp [] 배열을 dp [c+1]이 아닌 dp [c+101]을 선언
//  한 번 홍보할 때 유치할 수 있는 고객의 수가 100을 넘지 않기 때문에 dp [c]가 목표치지만 가성비 도시가 있어서 dp [c]>dp [c+20] 이런 상황이 나올 수 있기 때문에 dp [c+101]으로 선언
// 배열은 큰 수로 초기화 
// 도시가 주어졌을 때 비용과 고객 수를 cost, people로 할당
// 구해진 값을 비교하여 작은 값을 선택

public class BOJ20164 {

    static int n;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = 0;
        func(n, getOddCnt(n));
        System.out.println(min + " " + max);
    }

    static void func(int num, int cnt) {
        // 한 자리
        if (num <= 9) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        // 두 자리
        if (num <= 99) {
            int next = (num / 10) + (num % 10);
            func(next, getOddCnt(next) + cnt);
        }

        // 세 자리 이상
        String s = Integer.toString(num);

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                String x1 = s.substring(0, i + 1); // s[0..i]
                String x2 = s.substring(i + 1, j + 1); // s[i+1..j]
                String x3 = s.substring(j + 1, s.length()); // s[j+1..end]

                int nx = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                func(nx, getOddCnt(nx) + cnt);
            }
        }
    }

    // x라는 수 안에 홀수가 몇 개 있는지
    static int getOddCnt(int x) {
        int ret = 0;
        while (x > 0) {
            int digit = x % 10;
            if (digit % 2 == 1)
                ret++;
            x /= 10;
        }
        return ret;
    }

}
