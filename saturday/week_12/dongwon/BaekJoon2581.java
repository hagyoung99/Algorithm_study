package math;

import java.util.Scanner;

public class BaekJoon2581 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            for (int j = 2; j <= i; j++) {
                if (i == j) {
                    sum += i;
                    min = Math.min(min, i);
                }
                else if (i % j == 0) break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
