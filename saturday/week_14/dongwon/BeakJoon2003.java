package Two_point;

import java.util.Scanner;

public class BeakJoon2003 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int start = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            while (sum > M) {
                sum -= arr[start];
                start++;
            }
            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}
