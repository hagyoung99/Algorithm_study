package BOJ.boj10655;

import java.util.Scanner;

public class Main {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n][2];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            sum += getDist(i, i + 1);
        }

        int min = sum;
        for (int i = 1; i < n - 1; i++) {
            int temp = sum - (getDist(i - 1, i) + getDist(i, i + 1)) + getDist(i - 1, i + 1);
            min = Math.min(temp, min);
        }

        System.out.println(min);
    }

    private static int getDist(int x, int y) {
        return Math.abs(arr[x][0] - arr[y][0]) + Math.abs(arr[x][1] - arr[y][1]);
    }
}
