package BOJ.boj2096;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        if (n == 1) {
            System.out.println(Math.max(Math.max(arr[0][0], arr[0][1]), arr[0][2]));
            System.out.println(Math.min(Math.min(arr[0][0], arr[0][1]), arr[0][2]));
            System.exit(0);
        }

        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            maxDp[i][0] = minDp[i][0] = arr[i][0];
            maxDp[i][1] = minDp[i][1] = arr[i][1];
            maxDp[i][2] = minDp[i][2] = arr[i][2];
        }

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];

            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }

        System.out.print(Math.max(Math.max(maxDp[n - 1][0], maxDp[n - 1][1]), maxDp[n - 1][2]) + " ");
        System.out.println(Math.min(Math.min(minDp[n - 1][0], minDp[n - 1][1]), minDp[n - 1][2]));
    }
}
