package Two_point;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1806 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int arr[] = new int[N];

        boolean max = false;
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int size = arr.length - 1;
        int short_ = arr.length - 1;

        Arrays.sort(arr);

        while (end <= size) {
            if (sum(arr, start, end) >= S) {
                if (short_ >= (end - start)) {
                    short_ = end - start;
                    max = true;
                }
                start++;
                if (start > end) end = start;
            } else end++;
        }

        if (max) {
            System.out.println(short_);
        } else System.out.println(0);
    }

    public static int sum(int arr[], int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) sum += arr[i];
        return sum;
    }
}
