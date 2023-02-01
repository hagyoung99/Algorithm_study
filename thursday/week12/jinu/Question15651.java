package thursday.week12.jinu;
// 15651번 N과 M(3)(https://www.acmicpc.net/problem/15651)

import java.util.Scanner;

public class Question15651 {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        solve(0);
        System.out.print(sb);

        sc.close();
    }

    public static void solve(int nandm) {

        // 깊이과 M이랑 같아지면 출력후 return
        if (nandm == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[nandm] = i;
            solve(nandm + 1);
        }
    }

}
