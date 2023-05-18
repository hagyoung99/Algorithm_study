package BOJ.boj1421;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();
        int[] trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            max = Math.max(max, trees[i]);
        }

        long answer = 0L;
        for (int i = 1; i <= max; i++) {
            long sum = 0;
            for (int j = 0; j < trees.length; j++) {
                if (trees[j] >= i) {
                    long piece = trees[j] / i;
                    long div;
                    if (trees[j] % i == 0) {
                        div = piece - 1;
                    } else {
                        div = piece;
                    }
                    long temp = piece * W * i - div * C;
                    if (temp > 0) {
                        sum += temp;
                    }
                }
            }
            answer = Math.max(sum, answer);
        }

        System.out.println(answer);

    }
}
