package math;

import java.util.Scanner;

public class BOJ_9613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();

            //GCD 합 초기화
            long sum = 0;
            int []input = new int[n];

            for(int j = 0; j < n; j++) {
                input[j] = sc.nextInt();
            }

            for(int r = 0; r < n; r++) {
                for(int c = r; c < n; c++) {
                    sum += GCD(input[r], input[c]);
                }
            }
            System.out.println(sum);

        }

    }
    public static int GCD(int a, int b) {
        while(b != 0) {
            int r = a%b;
            //GCD(a, b) = GCD(b, r)
            a = b;
            b = r;
        }
        return a;
    }
}


// 유클리드 호제법