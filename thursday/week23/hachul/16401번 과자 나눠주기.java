package BOJ.boj16401;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] snacks;
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); // 조카의 수
        n = sc.nextInt(); // 과자의 수

        snacks = new int[n];

        for (int i = 0; i < n; i++) {
            snacks[i] = sc.nextInt();
        }

        Arrays.sort(snacks);

        long lo = 1;
        long hi = snacks[snacks.length - 1];
        long result = 0;

        while (lo <= hi) {
            int cnt = 0;
            long mid = lo + (hi - lo) / 2;

            for (int i = 0; i < n; i++) {
                cnt += snacks[i] / mid;
            }

            if (cnt >= m) {
                if (result < mid) {
                    result = mid;
                }
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(result);
    }
}
