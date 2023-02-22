package Two_point;

import java.util.Scanner;

public class BeakJoon6159 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int arr[] = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] <= S) count++;
            }
        }
        System.out.println(count);
    }
}
