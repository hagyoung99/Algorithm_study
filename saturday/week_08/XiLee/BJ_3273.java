package week8;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        int start = 0;
        int end = n-1;
        int ans = 0;

        Arrays.sort(arr);

        while(start < end) {
            if(arr[start] + arr[end] > x) end--;
            else if(arr[start] + arr[end] == x) {
                ans++;
                end--;
            } else start++;
        }

        System.out.println(ans);
    }
}

