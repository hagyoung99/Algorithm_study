package Two_point;

import java.util.Scanner;

public class BeakJoon2559 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int start = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (i - start == K - 1) {
                max = Math.max(sum, max);
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(max);
    }
}
