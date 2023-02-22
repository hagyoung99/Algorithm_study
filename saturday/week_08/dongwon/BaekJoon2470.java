package Two_point;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2470 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        int first = 0, second = 0;

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int start = 0, end = arr.length - 1;
        int max = 2000000000;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (max > Math.abs(sum)) {
                max = Math.abs(sum);
                first = arr[start];
                second = arr[end];
            }
            if (sum > 0) end--;
            else start++;
        }
        System.out.println(first + " " + second);
    }
}
