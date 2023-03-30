package BOJ.boj15903;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }

        System.out.println(Arrays.stream(arr).sum());
    }
}
