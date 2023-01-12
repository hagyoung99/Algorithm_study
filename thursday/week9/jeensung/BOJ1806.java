package samsung01.jeensung;

import java.util.*;
public class BOJ1806 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            if(arr[i] >= s){
                System.out.println(1);
                System.exit(0);
            }
        }
        if(s == 0){
            System.out.println(1);
            System.exit(0);
        }
        int count = n+1;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= right && right <= n) {
            if (s > sum) {
                sum += arr[right];
                right++;
            } else {
                sum -= arr[left];
                count = Math.min(count, right - left);
                left++;
            }
        }
        if(count == n + 1)
            System.out.println(0);
        else
            System.out.println(count);
    }
}
