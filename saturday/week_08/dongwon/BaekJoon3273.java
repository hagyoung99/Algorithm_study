package Two_point;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon3273 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int count = 0;
        int start = 0;
        int end = n-1;
        int sum = 0;

        Arrays.sort(arr);

        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum > x) end--;
            if (sum < x) start++;
            if (sum == x) {
                count++;
                start++;
            }
        }
        System.out.println(count);
    }
}
