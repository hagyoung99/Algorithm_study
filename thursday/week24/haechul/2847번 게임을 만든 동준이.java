package BOJ.boj2847;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        int[] list = new int[n];


        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = n - 2; i >= 0; i--) {
            if (list[i + 1] <= list[i]) {
                int diff = list[i] - list[i + 1] + 1;
                list[i] -= diff;
                cnt += diff;
            }
        }

        System.out.println(cnt);
    }
}
