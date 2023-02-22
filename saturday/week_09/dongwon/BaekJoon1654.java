package explore_person;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1654 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int K_arr[] = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            K_arr[i] = sc.nextInt();
            if (max < K_arr[i])
            {
                max = K_arr[i];
            }
        }
        max++;

        long min = 0;
        long mid = 0;

        while (min < max)
        {
            mid = (max + min) / 2;

            long count = 0;

            for (int i = 0; i < K_arr.length; i++) {
                count += (K_arr[i] / mid);
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(mid - 1);
    }
}
