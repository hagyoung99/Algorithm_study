package thursday.week12.jinu;

import java.util.Scanner;

// 15652번 N과 M(4)(https://www.acmicpc.net/problem/15652)
public class Question15652 {

    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        solve(1, 0);

        sc.close();

    }

    public static void solve(int descend, int nandm) {

        if (nandm == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = descend; i <= N; i++) {
            arr[nandm] = i;
            solve(i, nandm + 1);
        }

    }
}
